package org.selenide.bs;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {
  @Test
  void search() {
    open("https://selenide.org");
    $(".main-menu-pages").find(byText("Users")).click();

    $$("#user-tags .tag").shouldHave(sizeGreaterThan(8));
    $$("#selenide-users .user").shouldHave(sizeGreaterThan(20));
  }
}
