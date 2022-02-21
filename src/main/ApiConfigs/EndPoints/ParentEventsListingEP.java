package main.ApiConfigs.EndPoints;

public interface ParentEventsListingEP {

    String fetchParentEventsEP = "/api/v1/events/get-parent-events";

    String fetchParentEventsForConsumerEP = "/api/v2/events/fetch-parent-events-for-consumers";

    String fetchTrendingEventsEP = "/api/v2/events/fetch-trending-events";

    String fetchNearbyParentEventsForConsumerEP = "/api/v2/events/fetch-nearby-parent-events";
}
