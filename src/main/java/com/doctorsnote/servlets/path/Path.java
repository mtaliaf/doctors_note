package com.doctorsnote.servlets.path;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableMap;

public class Path {

  private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\{(\\w+)\\}");
  private static final String VARIABLE_REPLACE_STRING = "(\\\\w+)";

  private final Pattern servletPathRegex;
  private final ImmutableMap<String, Integer> pathVariables;

  public static Path from(String path) {
    return new Path(path);
  }

  private Path(String path) {
    this.servletPathRegex = toServletPath(path);
    this.pathVariables = parseVariables(path);
  }

  public Pattern getServletPathRegex() {
    return servletPathRegex;
  }

  public String getServletPath() {
    return servletPathRegex.pattern();
  }

  ImmutableMap<String, Integer> getVariableToGroupMap() {
    return pathVariables;
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
    this.pathVariables.entrySet().forEach(entry ->
        toStringHelper.add(entry.getKey(), entry.getValue()));

    return toStringHelper.toString();
  }
}
