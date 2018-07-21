package com.lunch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.Objects;

/** Immutable class consisting of a single Ingredients Data. */
public class Ingredient {
  private String title;

  @JsonAlias("best-before")
  private String bestBefore;

  @JsonAlias("use-by")
  private String useBy;

  private LocalDate bestBeforeDate;

  private LocalDate useByDate;

  /**
   * Immutable Object describing and ingredient and its best before and use by dates.
   *
   * @param title Title of ingredient
   * @param bestBefore best before date as a string which will be parsed to LocalDate
   * @param useBy used by date as a string which will be parsed to LocalDate
   */
  @JsonCreator
  public Ingredient(
      @JsonProperty("title") String title,
      @JsonProperty("best-before") String bestBefore,
      @JsonProperty("use-by") String useBy) {
    this.title = title;
    this.bestBefore = bestBefore;
    this.useBy = useBy;
    this.bestBeforeDate = LocalDate.parse(bestBefore);
    this.useByDate = LocalDate.parse(useBy);
  }

  public String getTitle() {
    return title;
  }

  public String getBestBefore() {
    return bestBefore;
  }

  public String getUseBy() {
    return useBy;
  }

  @Transient
  public LocalDate getBestBeforeDate() {
    return bestBeforeDate;
  }

  @Transient
  public LocalDate getUseByDate() {
    return useByDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ingredient that = (Ingredient) o;
    return Objects.equals(title, that.title)
        && Objects.equals(bestBefore, that.bestBefore)
        && Objects.equals(useBy, that.useBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, bestBefore, useBy);
  }

  @Override
  public String toString() {
    return "Ingredient{"
        + "title='"
        + title
        + '\''
        + ", bestBefore="
        + bestBefore
        + ", useBy="
        + useBy
        + '}';
  }
}
