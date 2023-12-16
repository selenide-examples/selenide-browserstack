package org.selenide.bs;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SimpleTest {
  @Test
  void search() {
    open("https://duckduckgo.com");
    $(By.name("q")).val("Selenide and BrowserStack").pressEnter();
    $$("[data-testid=\"result\"]").shouldHave(sizeGreaterThan(1));
    $("[data-testid=\"result\"]").shouldBe(visible).shouldHave(
      partialText("Run Selenium tests with Selenide"),
      partialText("BrowserStack Docs"));

  }
}
