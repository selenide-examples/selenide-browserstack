package org.selenide.bs;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.ClipboardConditions.content;
import static com.codeborne.selenide.Selenide.*;

public class ClipboardTest {
  @Test
  @Disabled
  void canCheckClipboardContent() {
    open("https://selenide.org/test-page/clipboard.html");
    $("#text-input").val("Hello BrowserStack!");
    $("#copy-button").click();
    clipboard().shouldHave(content("Hello BrowserStack!"));
  }
}
