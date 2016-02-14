package com.doctorsnote.servlets.path;

import static com.google.common.truth.Truth.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.doctorsnote.servlets.path.Path;
import com.google.common.collect.ImmutableMap;

public class PathTest {
  String userPath = "/some/path/{var1}/foo/{var2}";
  String servletPath = "/some/path/(\\w+)/foo/(\\w+)";
  Map<String, Integer> variableToGroupMap = ImmutableMap.of("var1", 1, "var2", 2);
  Path path;

  @Before
  public void createServletPath() {
    path = Path.from(userPath);
  }

  @Test
  public void canCreatePath() throws Exception {
    assertThat(path.getServletPath()).isEqualTo(servletPath);
  }

  @Test
  public void canCreateVariableMap() throws Exception {
    assertThat(path.getVariableToGroupMap()).containsExactlyEntriesIn(variableToGroupMap);
  }
}
