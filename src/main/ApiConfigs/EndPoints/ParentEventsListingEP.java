package main.ApiConfigs.EndPoints;

public interface ParentEventsListingEP {

    String fetchParentEventsForConsumerEP = "/api/v2/events/fetch-parent-events-for-consumers";

    String fetchTrendingEvents = "/api/v2/events/fetch-trending-events";

    String fetchNearbyParentEvents = "/api/v2/events/fetch-nearby-parent-events";
}
