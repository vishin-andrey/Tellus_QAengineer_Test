require 'open-uri'
require 'rest-client'
require 'httparty'

# Class for API of the Giphy.com service
class GiphyAPI
  include HTTParty
  # Set API address
  base_uri 'api.giphy.com'
  # Set URL for the service's landing page
  @@LANDING_URI = 'http://giphy.com'
  # OK code for search test
  @@OKSEARCHCODE = 200

  def initialize
    # Searching through HTML code for variable name GIPHY_FE_MOBILE_API_KEY to get APY key for the session
    @api_key = URI.open(@@LANDING_URI).read.scan(/WEB_API_KEY = "(.*)"/)
    # Join key array to string
    @api_key = @api_key.join
  end
  # Search request for Giphy API
  def search(q_text, q_offset, q_limit)
    # Request options preparation
    @options = { query: { q: q_text, offset: q_offset, limit: q_limit, api_key: @api_key } }
    # GET request to API and return response
    # HTTParty handles request errors and includes status into the response variable
    return self.class.get('/v1/videos/search', @options)
  end
  # Check if search response is valid
  def isSearchRespValid(code)
    return code == @@OKSEARCHCODE
  end
end

# Parent class for tests with the result announcement methods
class Test
  def ok
    puts "Test PASSED"
  end

  def reject(err_message)
    puts "Test FILED." + err_message
  end
end

class TestGiphySearch < Test
  # Run search test with parameters: search query, offset and pagination limit
  def run(q, off, lim)
    puts "Search Test started"
    session = GiphyAPI.new
    puts "Session prepared"
    response = session.search(q, off, lim)
    # Check if response code is ok
    session.isSearchRespValid(response.code) ? self.ok : self.reject("Error code: #{response.code}")
  end
end

# Specify query, offset and pagination limit for the testcase
query = 'smile'
offset = 5
limit_for_pagination = 10

# TELLUS Test
TestGiphySearch.new.run(query, offset, limit_for_pagination)
