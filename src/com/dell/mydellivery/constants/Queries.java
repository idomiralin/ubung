/**
 * Copyright (c) Dell Services 2014.
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary
 * information of Dell Services ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered
 * into with Dell Services.
 * Unauthorized reproduction or distribution of this Confidential Information,
 * or any portion of it, may result in severe civil and criminal penalties.
*/
package com.dell.mydellivery.constants;

public interface Queries {
	
	public interface FoodOrder {
		String RETRIEVE_ALL_ID = "FoodOrder.RetrieveAll";
		String RETRIEVE_ALL = "SELECT fo FROM FoodOrder fo ORDER BY fo.creationDateTime DESC";

		String RETRIEVE_ALL_BY_OWNER_AND_STATUS_ID = "FoodOrder.RetrieveAllByOwnerAndStatus";
		String RETRIEVE_ALL_BY_OWNER_AND_STATUS = "SELECT fo FROM FoodOrder fo WHERE fo.owner.id = :ownerId AND fo.status = :orderStatus";
		
		String RETRIEVE_ALL_BY_STATUS_ID = "FoodOrder.retrieveAllByStatus";
		String RETRIEVE_ALL_BY_STATUS = "SELECT fo FROM FoodOrder fo WHERE fo.status = :orderStatus ORDER BY fo.creationDateTime DESC";

		String RETRIEVE_ALL_ACTIVE_OR_POLLING_ID = "FoodOrder.retrieveAllActiveOrPolling";
		String RETRIEVE_ALL_ACTIVE_OR_POLLING = "SELECT fo FROM FoodOrder fo WHERE fo.status = :active OR fo.status = :polling ORDER BY fo.creationDateTime DESC";

		String RETRIEVE_ALL_ACTIVE_OR_POLLING_BY_OWNER_ID = "FoodOrder.retrieveAllActiveOrPollingByOwner";
		String RETRIEVE_ALL_ACTIVE_OR_POLLING_BY_OWNER = "SELECT fo FROM FoodOrder fo WHERE fo.owner.id = :ownerId AND (fo.status = :active OR fo.status = :polling) ORDER BY fo.creationDateTime DESC";
		
		String RETRIEVE_ALL_BY_USER_ID = "FoodOrder.RetrieveAllByUser";
		String RETRIEVE_ALL_BY_USER = "SELECT fo FROM FoodOrder fo WHERE fo.owner.id = :ownerId";

		String GET_FOODORDER_BY_ID_ID = "FoodOrder.getFoodOrderById";
		String GET_FOODORDER_BY_ID = "SELECT fo FROM FoodOrder fo WHERE fo.id= :id";

		String RETRIEVE_ALL_BY_PARTICIPANT_ID = "FoodOrder.getAllByParticipantId";
		String RETRIEVE_ALL_BY_PARTICIPANT = "SELECT distinct fo FROM FoodOrder fo , Item i   WHERE  (i.owner.id= :ownerId) AND (fo.id=i.foodOrder.id) order by fo.creationDateTime desc";

		String RETRIEVE_ALL_UNRATED_BY_PARTICIPANT_ID = "FoodOrder.getOldestUnratedByPartycipant";
		String RETRIEVE_ALL_UNRATED_BY_PARTICIPANT = "SELECT distinct fo FROM FoodOrder fo , Item i WHERE  (i.owner.id = :userId) AND "
				+ "(fo.id = i.foodOrder.id) AND " + "(fo.status = :orderStatus) AND"
				+ "( fo.id NOT IN (SELECT r.foodOrder.id FROM Rating r WHERE r.user.id = :userId) ) ORDER BY fo.creationDateTime";

	}

	public interface User {
		String RETRIEVE_ALL_ID = "User.retrieveAll";
		String RETRIEVE_ALL = "SELECT u FROM User u";

		String GET_USER_BY_CREDENTIALS_ID = "User.getUserByCredentials";
		String GET_USER_BY_CREDENTIALS = "SELECT u FROM User u WHERE u.emailAddress = :emailAddress AND u.password = :password";

		String GET_USER_BY_EMAIL_ID = "User.getUserByEmail";
		String GET_USER_BY_EMAIL = "SELECT u FROM User u WHERE u.emailAddress=:emailAddress";

		String GET_USERS_BY_PARTIAL_IDENTIFIER_ID = "User.getUsersByPartialIdentifier";
		String GET_USERS_BY_PARTIAL_IDENTIFIER = "SELECT u FROM User u WHERE lower(concat(u.name , ' ', u.surname)) LIKE :partialIdentifier OR lower(u.emailAddress) LIKE :partialIdentifier)";

		String GET_USER_BY_IDENTIFIER_ID = "User.getUserByIdentifier";
		String GET_USER_BY_IDENTIFIER = "SELECT u FROM User u WHERE (lower(concat(u.name , ' ', u.surname)) = :identifier) OR (u.emailAddress = :identifier) ";

	}

	public interface Item {
		String RETRIEVE_ALL_ID = "Item.retrieveAll";
		String RETRIEVE_ALL = "SELECT i FROM Item i";

		String GET_ITEM_BY_ID_ID = "Item.getItemById";
		String GET_ITEM_BY_ID = "SELECT i FROM Item i WHERE i.id = :id";

		String GET_ITEM_BY_OWNER_AND_FOODORDER_ID = "Item.getItemByOwnerAndFoodOrderId";
		String GET_ITEM_BY_OWNER_AND_FOODORDER = "SELECT i FROM Item i WHERE i.owner.id = :ownerId";
	
		String RETRIEVE_ALL_BY_OWNER_ID_RESTAURANT_ID_AND_PARTIALCONTENT_ID ="Item.getItemByOwnerIdRestaurantIdAndPartialContent";
		//TODO query that retrieves items by restaurant id , user id and 
		String RETRIEVE_ALL_BY_OWNER_ID_RESTAURANT_ID_AND_PARTIALCONTENT="SELECT i FROM Item i WHERE (i.owner.id = :ownerId) AND (i.foodOrder.restaurant.id= :restaurantId) AND (lower(i.content) LIKE :partialContent) ";
	}

	public interface Restaurant {
		String RETRIEVE_ALL_ID = "Restaurant.retrieveAll";
		String RETRIEVE_ALL = "SELECT r from Restaurant r ORDER BY r.restaurantName";

		String GET_RESTAURANT_BY_NAME_ID = "Restaurant.getRestaurantByName";
		String GET_RESTAURANT_BY_NAME = "SELECT r from Restaurant r WHERE r.restaurantName = :restaurantName";

		String GET_RESTAURANT_BY_ID_ID = "Restaurant.getRestaurantById";
		String GET_RESTAURANT_BY_ID = "SELECT r from Restaurant r WHERE r.id = :restaurantId";

		String IS_RESTAURANTS_EMPTY_ID = "Restaurant.isRestaurantsEmpty";
		String IS_RESTAURANTS_EMPTY = "SELECT 1 FROM Restaurant r";

		String GET_NUMBER_OF_RESTAURANTS_ID = "Restaurant.getNumberOfRestaurants";
		String GET_NUMBER_OF_RESTAURANTS = "SELECT COUNT(r) FROM Restaurant r";
	}

	public interface Rating {
		String RETRIEVE_BY_RESTAURANT_ID = "Rating.retrieveByRestaurant";
		String RETRIEVE_BY_RESTAURANT = "SELECT r from Rating r WHERE r.restaurant.id= :restaurantId ORDER BY r.ratingDateTime";

		String RETRIEVE_BY_FOOD_ORDER_ID = "Rating.retrieveByFoodOrder";
		String RETRIEVE_BY_FOOD_ORDER = "SELECT r from Rating r WHERE r.foodOrder = :foodOrder ORDER BY r.ratingDateTime";

		String RETRIEVE_BY_USER_AND_FOODORDER_ID = "Rating.retrieveAllUserRatings";
		String RETRIEVE_BY_USER_AND_FOODORDER = "SELECT r FROM Rating r WHERE r.user.id= :userId AND r.foodOrder.id = :foodOrderId";

	}

	public interface PollingOrderVoteSummary {
		String RETRIEVE_BY_RESTAURANT_AND_FOODORDER_ID = "PollingOrderVoteSummary.retrieveByRestaurantAndFoodOrder";
		String RETRIEVE_BY_RESTAURANT_AND_FOODORDER = "SELECT s from PollingOrderVoteSummary s WHERE s.restaurant.id =  :restaurantId AND s.foodOrder.id = :foodOrderId";
	}

	public interface PollingOrderVote {
		String RETRIEVE_NR_VOTES_PER_USER_ID = "PollingOrderVote.retrieveNrVotesPerUser";
		String RETRIEVE_NR_VOTES_PER_USER = "SELECT COUNT(v) from PollingOrderVote v WHERE v.foodOrder.id = :foodOrderId AND v.user.id = :userId";
	}

}
