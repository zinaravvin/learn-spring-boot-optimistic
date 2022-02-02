package org.openapi.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapi.example.model.SelectHDStopTransResponseData;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SelectHDStopTransResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-26T23:18:41.423035-05:00[America/New_York]")
public class SelectHDStopTransResponse   {
  @JsonProperty("transactions")
  @Valid
  private List<SelectHDStopTransResponseData> transactions = new ArrayList<SelectHDStopTransResponseData>();

  public SelectHDStopTransResponse transactions(List<SelectHDStopTransResponseData> transactions) {
    this.transactions = transactions;
    return this;
  }

  public SelectHDStopTransResponse addTransactionsItem(SelectHDStopTransResponseData transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * Get transactions
   * @return transactions
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<SelectHDStopTransResponseData> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<SelectHDStopTransResponseData> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelectHDStopTransResponse selectHDStopTransResponse = (SelectHDStopTransResponse) o;
    return Objects.equals(this.transactions, selectHDStopTransResponse.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelectHDStopTransResponse {\n");
    
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

