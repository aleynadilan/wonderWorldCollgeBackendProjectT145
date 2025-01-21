Feature: As an administrator (admin) I want to be able to access Purpose List via API connection.

  Scenario Outline: Verify that a GET request to the `/api/visitorsPurposeList` endpoint with valid authorization returns
  a 200 status code, a "Success" message, and the `visitors_purpose`, `description`, and `created_at` fields for ID (x)
  in the response body.

    * The api user constructs the base url with the "admin" token.
    # Api kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/visitorsPurposeList" path parameters.
    # Api kullanicisi "/api/visitorsPurposeList" path parametrelerini olusturur
    * The api user sends a GET request and saves the returned response.
    # Api kullanicisi GET request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Success".
    # Api kullanicisi response bodydeki message bilgisinin "Success" oldugunu dogrular
    * The api user verifies the information in the response body for the entry with the specified <dataIndex> index, including "<visitors_purpose>", "<description>" and "<created_at>".
    # Api kullanıcısı response body icindeki <dataIndex> indexe sahip olanin "<visitors_purpose>", "<description>" ve "<created_at>" bilgilerini doğrular.

    Examples:
      | dataIndex | visitors_purpose | description            | created_at          |
      | 0         | purpose update   | came for student visit | 2025-01-06 18:12:16 |

  Scenario: Verify that a GET request to /api/visitorsPurposeList with invalid authorization returns a 403 status code and a
  "failed" message.

    * The api user constructs the base url with the "invalid" token.
    # Api kullanicisi "invalid" token ile base urli olusturur
    * The api user sets "api/visitorsPurposeList" path parameters.
    # Api kullanicisi "/api/visitorsPurposeList" path parametrelerini olusturur
    * The api user sends a GET request, saves the returned response, and verifies that the status code is '403' with the reason phrase Forbidden.
    # Api kullanicisi GET request gonderir, donen responsei kaydeder, status codeun '403' ve reason phrase bilgisinin Forbidden oldugunu dogrular
