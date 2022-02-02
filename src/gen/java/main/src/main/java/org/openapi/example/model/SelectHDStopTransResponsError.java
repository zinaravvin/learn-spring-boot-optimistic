package org.openapi.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SelectHDStopTransResponsError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-26T23:18:41.423035-05:00[America/New_York]")
public class SelectHDStopTransResponsError   {
  @JsonProperty("product_id")
  private String productId;

  @JsonProperty("error_code")
  private Integer errorCode;

  @JsonProperty("error_msg")
  private String errorMsg;

  @JsonProperty("original_transaction_id")
  private String originalTransactionId;

  public SelectHDStopTransResponsError productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public SelectHDStopTransResponsError errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public SelectHDStopTransResponsError errorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
    return this;
  }

  /**
   * Get errorMsg
   * @return errorMsg
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public SelectHDStopTransResponsError originalTransactionId(String originalTransactionId) {
    this.originalTransactionId = originalTransactionId;
    return this;
  }

  /**
   * Get originalTransactionId
   * @return originalTransactionId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getOriginalTransactionId() {
    return originalTransactionId;
  }

  public void setOriginalTransactionId(String originalTransactionId) {
    this.originalTransactionId = originalTransactionId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectHDStopTransResponsError selectHDStopTransResponsError = (SelectHDStopTransResponsError) o;
    return Objects.equals(this.productId, selectHDStopTransResponsError.productId) &&
        Objects.equals(this.errorCode, selectHDStopTransResponsError.errorCode) &&
        Objects.equals(this.errorMsg, selectHDStopTransResponsError.errorMsg) &&
        Objects.equals(this.originalTransactionId, selectHDStopTransResponsError.originalTransactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, errorCode, errorMsg, originalTransactionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectHDStopTransResponsError {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorMsg: ").append(toIndentedString(errorMsg)).append("\n");
    sb.append("    originalTransactionId: ").append(toIndentedString(originalTransactionId)).append("\n");
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

