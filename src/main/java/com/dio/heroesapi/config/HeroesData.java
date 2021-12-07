package com.dio.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB; //ok
import com.amazonaws.services.dynamodbv2.document.Table;  //ok
import com.amazonaws.services.dynamodbv2.document.Item;  //ok
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;  //ok
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition; //ok
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement; //ok
import com.amazonaws.services.dynamodbv2.model.KeyType; //ok
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput; //ok
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType; //ok
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories; //ok
import org.springframework.context.annotation.Configuration; //ok
import java.util.Arrays;
import org.springframework.util.StringUtils; //ok
import static com.dio.heroesapi.constans.HeroesConstant.REGION_DYNAMO;
import static com.dio.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;


public class HeroesData {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table_test3");

        Item hero = new Item()
                .withPrimaryKey("id","2")
                .withString("name", "Mulher Maravilha")
                .withString("universe","dc comics")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Viuva negra")
                .withString("universe", "marvel")
                .withNumber("films", 2);


        PutItemOutcome outcome = table.putItem(hero);
        PutItemOutcome outcome2 = table.putItem(hero2);
    }
}
