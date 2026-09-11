package com.example

import org.junit.Assert.*
import org.junit.Test
import java.io.File

class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun testIndexHtmlContainsOverdueAllowanceLogic() {
    val assetFile = File("src/main/assets/index.html")
    assertTrue("index.html should exist", assetFile.exists())
    val content = assetFile.readText()

    assertTrue(
      "Should detect isAllowanceOverdue explicitly",
      content.contains("isAllowanceOverdue")
    )
    assertTrue(
      "Should compute daysOverdue",
      content.contains("daysOverdue")
    )
    assertTrue(
      "Should format overdue label",
      content.contains("\${daysOverdue} \${dayWord} overdue")
    )
    assertTrue(
      "Should include status-overdue CSS class",
      content.contains(".safe-pill-badge.status-overdue")
    )
  }
}

