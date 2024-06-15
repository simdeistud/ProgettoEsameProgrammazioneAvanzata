package parsers.request;

public class Request {

  private final String content;

  public Request(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return content;
  }

}
