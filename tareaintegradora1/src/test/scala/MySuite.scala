// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html

//Fix whole errors in all the test cases
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
}
