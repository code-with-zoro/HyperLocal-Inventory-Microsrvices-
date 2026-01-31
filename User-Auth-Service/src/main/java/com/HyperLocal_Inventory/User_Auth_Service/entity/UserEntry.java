package com.HyperLocal_Inventory.User_Auth_Service.entity;


import com.HyperLocal_Inventory.User_Auth_Service.enums.Roles;
import com.fasterxml.jackson.databind.annotation.EnumNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.Point;

@Document(collection = "users")
@Schema(hidden = true)
public class UserEntry {

   @Id
   private ObjectId id;

   @NotBlank
   private String userName;

   @Indexed(unique = true)
   @NotBlank
   private String email;

   @NotBlank
   private String password;


   private Roles roles;

   @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
   private Point location;



   //Getters and Setters

   public ObjectId getId() {
      return id;
   }

   public void setId(ObjectId id) {
      this.id = id;
   }

   public @NotBlank(message = "Enter Your Name") String getUserName() {
      return userName;
   }

   public void setUserName(@NotBlank(message = "Enter Your Name") String userName) {
      this.userName = userName;
   }

   public @NotBlank(message = "Enter Your Email") String getEmail() {
      return email;
   }

   public void setEmail(@NotBlank(message = "Enter Your Email") String email) {
      this.email = email;
   }

   public @NotBlank(message = "Enter your Password") String getPassword() {
      return password;
   }

   public void setPassword(@NotBlank(message = "Enter your Password") String password) {
      this.password = password;
   }

   public Roles getRoles() {
      return roles;
   }

   public void setRoles(Roles roles) {
      this.roles = roles;
   }

   public Point getLocation() {
      return location;
   }

   public void setLocation(Point location) {
      this.location = location;
   }
}
