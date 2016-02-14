package com.doctorsnote.servlets.path;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;

import com.google.common.collect.ImmutableMap;

public class PathParser {

  private final Map<String, String> pathParameterMap;

  public static PathParser from(Path servletPath, String requestPath) {
    return new PathParser(servletPath, requestPath);
  }

  public String getPathParameter(String parameterKey) {
    checkArgument(pathParameterMap.containsKey(parameterKey));
    return checkNotNull(pathParameterMap.get(parameterKey));
  }

  private PathParser(Path servletPath, String requestPath) {
    this.pathParameterMap = parsePathParameterMap(servletPath, requestPath);
  }

  private Map<String, String> parsePathParameterMap(Path servletPath, String requestPath) {
    Map<String, String> pathParameterMap = new HashMap<>();
    Matcher matcher = servletPath.getServletPathRegex().matcher(requestPath);
    checkState(matcher.find());
    for (Entry<String, Integer> entry : servletPath.getVariableToGroupMap().entrySet()) {
      pathParameterMap.put(entry.getKey(), matcher.group(entry.getValue()));
    }

    return ImmutableMap.copyOf(pathParameterMap);
  }
}
