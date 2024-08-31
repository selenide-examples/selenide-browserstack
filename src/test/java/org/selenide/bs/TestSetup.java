package org.selenide.bs;

import java.util.Map;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.codeborne.selenide.Configuration;

public class TestSetup implements BeforeAllCallback {
  private final String username = System.getenv("BROWSERSTACK_USERNAME");
  private final String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

  /**
   * See all <a href="https://www.browserstack.com/automate/capabilities">BrowserStack settings</a>
   */
  @Override public void beforeAll(ExtensionContext context) {
    Configuration.remote = "https://hub-cloud.browserstack.com/wd/hub";
    Configuration.browserCapabilities.setCapability("bstack:options", Map.of(
      "source", "selenide-examples:selenide-browserstack:main",
      "userName", username,
      "accessKey", accessKey
    ));
  }

}
