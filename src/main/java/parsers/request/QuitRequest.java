package parsers.request;

import java.util.List;

public class QuitRequest extends TokenizedRequest {

  protected QuitRequest(String req, List<String> tokens) {
    super(req, tokens, RequestType.QUIT);
  }
}
