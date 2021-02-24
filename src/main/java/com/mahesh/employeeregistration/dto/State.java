package com.mahesh.employeeregistration.dto;

public enum State {
  ADDED,
  INCHECK,
  APPROVED,
  ACTIVE;

  public static String toCommaString() {
    StringBuilder result = new StringBuilder();
    for (State s : State.values()) {
      result.append(s.toString());
      result.append(",");
    }
    return result.length() > 0 ? result.substring(0, result.length() - 1) : "";
  }
}
