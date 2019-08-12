package cn.com.huaruan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(indexName = "user",type = "docs", shards = 1, replicas = 0)
public class User implements Serializable {
    @Id
    private Integer userId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String account;
    @Field(type = FieldType.Keyword)
    private String pwd;
    @Field(type = FieldType.Keyword)
    private String realName;
    /**
     * 性别, 0-男; 1-女
     */
    @Field(type = FieldType.Integer)
    private int sex;
    @Field(type = FieldType.Keyword)
    private String idCard;
    @Field(type = FieldType.Keyword)
    private String phone;
    @Field(type = FieldType.Keyword)
    private String addressProvince;
    @Field(type = FieldType.Keyword)
    private String addressCity;
    @Field(type = FieldType.Keyword)
    private String addressArea;
    @Field(type = FieldType.Keyword)
    private String addressDetails;
    @Field(type = FieldType.Keyword)
    private String email;
    @Field(index = false, type = FieldType.Keyword)
    private String pictureUrl;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Field(index = false, type = FieldType.Date)
    private Date registeredTime;
}
