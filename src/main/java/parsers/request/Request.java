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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return content.equals(((Request) o).content);
  }

}

