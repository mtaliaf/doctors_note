package com.doctors_note.servlets;

import static com.google.common.truth.Truth.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class ServletPathTest {
  String userPath = "/some/path/{var1}/foo/{var2}";
  String servletPath = "/some/path/(\\w+)/foo/(\\w+)";
  Map<String, Integer> variableToGroupMap = ImmutableMap.of("var1", 1, "var2", 2);
  ServletPath path;

  @Before
  public void createServletPath() {
    path = ServletPath.from(userPath);
  }

  @Test
  public void canCreatePath() throws Exception {
    assertThat(path.getServletPath()).isEqualTo(servletPath);
  }

  @Test
  public void canCreateVariableMap() throws Exception {
    assertThat(path.getVariableToGroupMap()).containsExactlyEntriesIn(variableToGroupMap);
  }

  @Test
  public void canReplaceVariables() throws Exception {
    String requestPath = "/some/path/bar/foo/zoo";
    Map<String, String> variableToValueMap = ImmutableMap.of("var1", "bar", "var2", "zoo");

    assertThat(path.getVariableToValueMap(requestPath)).containsExactlyEntriesIn(variableToValueMap);
  }
}
