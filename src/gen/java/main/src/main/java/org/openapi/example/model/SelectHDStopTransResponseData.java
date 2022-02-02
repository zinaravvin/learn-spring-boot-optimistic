package org.openapi.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapi.example.model.SelectHDStopTransResponsError;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SelectHDStopTransResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-26T23:18:41.423035-05:00[America/New_York]")
public class SelectHDStopTransResponseData   {
  @JsonProperty("errors")
  @Valid
  private List<SelectHDStopTransResponsError> errors = null;

  public SelectHDStopTransResponseData errors(List<SelectHDStopTransResponsError> errors) {
    this.errors = errors;
    return this;
  }

  public SelectHDStopTransResponseData addErrorsItem(SelectHDStopTransResponsError errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<SelectHDStopTransResponsError>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<SelectHDStopTransResponsError> getErrors() {
    return errors;
  }

  public void setErrors(List<SelectHDStopTransResponsError> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectHDStopTransResponseData selectHDStopTransResponseData = (SelectHDStopTransResponseData) o;
    return Objects.equals(this.errors, selectHDStopTransResponseData.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectHDStopTransResponseData {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

