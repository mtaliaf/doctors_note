package com.doctors_note.servlets;

import static com.google.common.base.Preconditions.checkState;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableMap;

public class ServletPath {

  private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\{(\\w+)\\}");
  private static final String VARIABLE_REPLACE_STRING = "(\\\\w+)";

  private final Pattern servletPathRegex;
  private final ImmutableMap<String, Integer> pathVariables;

  public static ServletPath from(String path) {
    return new ServletPath(path);
  }

  private ServletPath(String path) {
    this.servletPathRegex = toServletPath(path);
    this.pathVariables = parseVariables(path);
  }

  public String getServletPath() {
    return servletPathRegex.pattern();
  }

  ImmutableMap<String, Integer> getVariableToGroupMap() {
    return pathVariables;
  }

  public Map<String, String> getVariableToValueMap(String requestedPath) {
    Map<String, String> variableToValueMap = new HashMap<>();
    Matcher matcher = servletPathRegex.matcher(requestedPath);
    checkState(matcher.find());
    for (Entry<String, Integer> entry : getVariableToGroupMap().entrySet()) {
      variableToValueMap.put(entry.getKey(), matcher.group(entry.getValue()));
    }

    return ImmutableMap.copyOf(variableToValueMap);
  }

  private Pattern toServletPath(String path) {
    String regex = VARIABLE_PATTERN.matcher(path)
        .replaceAll(VARIABLE_REPLACE_STRING);
    return Pattern.compile(regex);
  }

  private ImmutableMap<String, Integer> parseVariables(String path) {
    int group = 1;
    Map<String, Integer> pathVariables = new HashMap<>();
    Matcher matcher = VARIABLE_PATTERN.matcher(path);
    while (matcher.find()) {
      pathVariables.put(matcher.group(1), group);
      group++;
    }

    return ImmutableMap.copyOf(pathVariables);
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.addValue(getServletPath());
    for (Entry<String, Integer> entry : this.pathVariables.entrySet()) {
      toStringHelper.add(entry.getKey(), entry.getValue());
    }

    return toStringHelper.toString();
  }
}
