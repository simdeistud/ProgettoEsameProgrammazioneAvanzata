package parsers.request;

import java.util.List;

public class StatRequest extends TokenizedRequest {

  private final StatKind kind;

  protected StatRequest(String req, List<String> tokens, StatKind kind) {
    super(req, tokens, RequestType.STAT);
    this.kind = kind;
  }

  public StatKind kind() {
    return kind;
  }

  public enum StatKind {
    REQS,
    AVG_TIME,
    MAX_TIME
  }
}
