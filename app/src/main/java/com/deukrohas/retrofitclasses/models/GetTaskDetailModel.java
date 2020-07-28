package com.deukrohas.retrofitclasses.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTaskDetailModel {

@SerializedName("message")
@Expose
private String message;
@SerializedName("status")
@Expose
private Integer status;
@SerializedName("data")
@Expose
private List<Datum> data = null;

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}

public List<Datum> getData() {
return data;
}

public void setData(List<Datum> data) {
this.data = data;
}
    public class Datum {

        @SerializedName("job_id")
        @Expose
        private Integer jobId;
        @SerializedName("created_by")
        @Expose
        private Integer createdBy;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("recurring_id")
        @Expose
        private String recurringId;
        @SerializedName("recurring_count")
        @Expose
        private Integer recurringCount;
        @SerializedName("partner_order_id")
        @Expose
        private Object partnerOrderId;
        @SerializedName("team_id")
        @Expose
        private Integer teamId;
        @SerializedName("vertical")
        @Expose
        private Integer vertical;
        @SerializedName("merchant_id")
        @Expose
        private Integer merchantId;
        @SerializedName("geofence")
        @Expose
        private Integer geofence;
        @SerializedName("tags")
        @Expose
        private String tags;
        @SerializedName("auto_assignment")
        @Expose
        private Integer autoAssignment;
        @SerializedName("dispatcher_id")
        @Expose
        private Object dispatcherId;
        @SerializedName("job_hash")
        @Expose
        private String jobHash;
        @SerializedName("has_pickup")
        @Expose
        private Integer hasPickup;
        @SerializedName("has_delivery")
        @Expose
        private Integer hasDelivery;
        @SerializedName("is_routed")
        @Expose
        private Integer isRouted;
        @SerializedName("pickup_delivery_relationship")
        @Expose
        private String pickupDeliveryRelationship;
        @SerializedName("job_description")
        @Expose
        private String jobDescription;
        @SerializedName("job_pickup_datetime")
        @Expose
        private String jobPickupDatetime;
        @SerializedName("job_pickup_name")
        @Expose
        private String jobPickupName;
        @SerializedName("job_pickup_phone")
        @Expose
        private String jobPickupPhone;
        @SerializedName("job_delivery_datetime")
        @Expose
        private String jobDeliveryDatetime;
        @SerializedName("job_pickup_latitude")
        @Expose
        private String jobPickupLatitude;
        @SerializedName("job_pickup_longitude")
        @Expose
        private String jobPickupLongitude;
        @SerializedName("job_pickup_address")
        @Expose
        private String jobPickupAddress;
        @SerializedName("job_pickup_email")
        @Expose
        private String jobPickupEmail;
        @SerializedName("job_latitude")
        @Expose
        private String jobLatitude;
        @SerializedName("job_longitude")
        @Expose
        private String jobLongitude;
        @SerializedName("customer_username")
        @Expose
        private String customerUsername;
        @SerializedName("customer_email")
        @Expose
        private String customerEmail;
        @SerializedName("customer_phone")
        @Expose
        private String customerPhone;
        @SerializedName("job_address")
        @Expose
        private String jobAddress;
        @SerializedName("creation_datetime")
        @Expose
        private String creationDatetime;
        @SerializedName("fleet_id")
        @Expose
        private Integer fleetId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("fleet_rating")
        @Expose
        private Integer fleetRating;
        @SerializedName("customer_comment")
        @Expose
        private Object customerComment;
        @SerializedName("is_customer_rated")
        @Expose
        private Integer isCustomerRated;
        @SerializedName("customer_id")
        @Expose
        private Integer customerId;
        @SerializedName("arrived_datetime")
        @Expose
        private String arrivedDatetime;
        @SerializedName("started_datetime")
        @Expose
        private String startedDatetime;
        @SerializedName("completed_datetime")
        @Expose
        private String completedDatetime;
        @SerializedName("acknowledged_datetime")
        @Expose
        private String acknowledgedDatetime;
        @SerializedName("job_status")
        @Expose
        private Integer jobStatus;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("job_type")
        @Expose
        private Integer jobType;
        @SerializedName("completed_by_admin")
        @Expose
        private Integer completedByAdmin;
        @SerializedName("open_tracking_link")
        @Expose
        private Integer openTrackingLink;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("job_time")
        @Expose
        private String jobTime;
        @SerializedName("job_date")
        @Expose
        private String jobDate;
        @SerializedName("job_time_utc")
        @Expose
        private String jobTimeUtc;
        @SerializedName("job_date_utc")
        @Expose
        private String jobDateUtc;
        @SerializedName("total_distance_travelled")
        @Expose
        private Object totalDistanceTravelled;
        @SerializedName("form_id")
        @Expose
        private Object formId;
        @SerializedName("customer_rating")
        @Expose
        private Object customerRating;
        @SerializedName("driver_comment")
        @Expose
        private Object driverComment;
        @SerializedName("remarks")
        @Expose
        private Object remarks;
        @SerializedName("barcode")
        @Expose
        private Object barcode;
        @SerializedName("ride_type")
        @Expose
        private Integer rideType;
        @SerializedName("matched_pickup_delivery_relationship")
        @Expose
        private Object matchedPickupDeliveryRelationship;
        @SerializedName("custom_field")
        @Expose
        private List<Object> customField = null;
        @SerializedName("tracking_link")
        @Expose
        private String trackingLink;

        public Integer getJobId() {
            return jobId;
        }

        public void setJobId(Integer jobId) {
            this.jobId = jobId;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getRecurringId() {
            return recurringId;
        }

        public void setRecurringId(String recurringId) {
            this.recurringId = recurringId;
        }

        public Integer getRecurringCount() {
            return recurringCount;
        }

        public void setRecurringCount(Integer recurringCount) {
            this.recurringCount = recurringCount;
        }

        public Object getPartnerOrderId() {
            return partnerOrderId;
        }

        public void setPartnerOrderId(Object partnerOrderId) {
            this.partnerOrderId = partnerOrderId;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

        public Integer getVertical() {
            return vertical;
        }

        public void setVertical(Integer vertical) {
            this.vertical = vertical;
        }

        public Integer getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(Integer merchantId) {
            this.merchantId = merchantId;
        }

        public Integer getGeofence() {
            return geofence;
        }

        public void setGeofence(Integer geofence) {
            this.geofence = geofence;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public Integer getAutoAssignment() {
            return autoAssignment;
        }

        public void setAutoAssignment(Integer autoAssignment) {
            this.autoAssignment = autoAssignment;
        }

        public Object getDispatcherId() {
            return dispatcherId;
        }

        public void setDispatcherId(Object dispatcherId) {
            this.dispatcherId = dispatcherId;
        }

        public String getJobHash() {
            return jobHash;
        }

        public void setJobHash(String jobHash) {
            this.jobHash = jobHash;
        }

        public Integer getHasPickup() {
            return hasPickup;
        }

        public void setHasPickup(Integer hasPickup) {
            this.hasPickup = hasPickup;
        }

        public Integer getHasDelivery() {
            return hasDelivery;
        }

        public void setHasDelivery(Integer hasDelivery) {
            this.hasDelivery = hasDelivery;
        }

        public Integer getIsRouted() {
            return isRouted;
        }

        public void setIsRouted(Integer isRouted) {
            this.isRouted = isRouted;
        }

        public String getPickupDeliveryRelationship() {
            return pickupDeliveryRelationship;
        }

        public void setPickupDeliveryRelationship(String pickupDeliveryRelationship) {
            this.pickupDeliveryRelationship = pickupDeliveryRelationship;
        }

        public String getJobDescription() {
            return jobDescription;
        }

        public void setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
        }

        public String getJobPickupDatetime() {
            return jobPickupDatetime;
        }

        public void setJobPickupDatetime(String jobPickupDatetime) {
            this.jobPickupDatetime = jobPickupDatetime;
        }

        public String getJobPickupName() {
            return jobPickupName;
        }

        public void setJobPickupName(String jobPickupName) {
            this.jobPickupName = jobPickupName;
        }

        public String getJobPickupPhone() {
            return jobPickupPhone;
        }

        public void setJobPickupPhone(String jobPickupPhone) {
            this.jobPickupPhone = jobPickupPhone;
        }

        public String getJobDeliveryDatetime() {
            return jobDeliveryDatetime;
        }

        public void setJobDeliveryDatetime(String jobDeliveryDatetime) {
            this.jobDeliveryDatetime = jobDeliveryDatetime;
        }

        public String getJobPickupLatitude() {
            return jobPickupLatitude;
        }

        public void setJobPickupLatitude(String jobPickupLatitude) {
            this.jobPickupLatitude = jobPickupLatitude;
        }

        public String getJobPickupLongitude() {
            return jobPickupLongitude;
        }

        public void setJobPickupLongitude(String jobPickupLongitude) {
            this.jobPickupLongitude = jobPickupLongitude;
        }

        public String getJobPickupAddress() {
            return jobPickupAddress;
        }

        public void setJobPickupAddress(String jobPickupAddress) {
            this.jobPickupAddress = jobPickupAddress;
        }

        public String getJobPickupEmail() {
            return jobPickupEmail;
        }

        public void setJobPickupEmail(String jobPickupEmail) {
            this.jobPickupEmail = jobPickupEmail;
        }

        public String getJobLatitude() {
            return jobLatitude;
        }

        public void setJobLatitude(String jobLatitude) {
            this.jobLatitude = jobLatitude;
        }

        public String getJobLongitude() {
            return jobLongitude;
        }

        public void setJobLongitude(String jobLongitude) {
            this.jobLongitude = jobLongitude;
        }

        public String getCustomerUsername() {
            return customerUsername;
        }

        public void setCustomerUsername(String customerUsername) {
            this.customerUsername = customerUsername;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public String getJobAddress() {
            return jobAddress;
        }

        public void setJobAddress(String jobAddress) {
            this.jobAddress = jobAddress;
        }

        public String getCreationDatetime() {
            return creationDatetime;
        }

        public void setCreationDatetime(String creationDatetime) {
            this.creationDatetime = creationDatetime;
        }

        public Integer getFleetId() {
            return fleetId;
        }

        public void setFleetId(Integer fleetId) {
            this.fleetId = fleetId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getFleetRating() {
            return fleetRating;
        }

        public void setFleetRating(Integer fleetRating) {
            this.fleetRating = fleetRating;
        }

        public Object getCustomerComment() {
            return customerComment;
        }

        public void setCustomerComment(Object customerComment) {
            this.customerComment = customerComment;
        }

        public Integer getIsCustomerRated() {
            return isCustomerRated;
        }

        public void setIsCustomerRated(Integer isCustomerRated) {
            this.isCustomerRated = isCustomerRated;
        }

        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public String getArrivedDatetime() {
            return arrivedDatetime;
        }

        public void setArrivedDatetime(String arrivedDatetime) {
            this.arrivedDatetime = arrivedDatetime;
        }

        public String getStartedDatetime() {
            return startedDatetime;
        }

        public void setStartedDatetime(String startedDatetime) {
            this.startedDatetime = startedDatetime;
        }

        public String getCompletedDatetime() {
            return completedDatetime;
        }

        public void setCompletedDatetime(String completedDatetime) {
            this.completedDatetime = completedDatetime;
        }

        public String getAcknowledgedDatetime() {
            return acknowledgedDatetime;
        }

        public void setAcknowledgedDatetime(String acknowledgedDatetime) {
            this.acknowledgedDatetime = acknowledgedDatetime;
        }

        public Integer getJobStatus() {
            return jobStatus;
        }

        public void setJobStatus(Integer jobStatus) {
            this.jobStatus = jobStatus;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public Integer getJobType() {
            return jobType;
        }

        public void setJobType(Integer jobType) {
            this.jobType = jobType;
        }

        public Integer getCompletedByAdmin() {
            return completedByAdmin;
        }

        public void setCompletedByAdmin(Integer completedByAdmin) {
            this.completedByAdmin = completedByAdmin;
        }

        public Integer getOpenTrackingLink() {
            return openTrackingLink;
        }

        public void setOpenTrackingLink(Integer openTrackingLink) {
            this.openTrackingLink = openTrackingLink;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getJobTime() {
            return jobTime;
        }

        public void setJobTime(String jobTime) {
            this.jobTime = jobTime;
        }

        public String getJobDate() {
            return jobDate;
        }

        public void setJobDate(String jobDate) {
            this.jobDate = jobDate;
        }

        public String getJobTimeUtc() {
            return jobTimeUtc;
        }

        public void setJobTimeUtc(String jobTimeUtc) {
            this.jobTimeUtc = jobTimeUtc;
        }

        public String getJobDateUtc() {
            return jobDateUtc;
        }

        public void setJobDateUtc(String jobDateUtc) {
            this.jobDateUtc = jobDateUtc;
        }

        public Object getTotalDistanceTravelled() {
            return totalDistanceTravelled;
        }

        public void setTotalDistanceTravelled(Object totalDistanceTravelled) {
            this.totalDistanceTravelled = totalDistanceTravelled;
        }

        public Object getFormId() {
            return formId;
        }

        public void setFormId(Object formId) {
            this.formId = formId;
        }

        public Object getCustomerRating() {
            return customerRating;
        }

        public void setCustomerRating(Object customerRating) {
            this.customerRating = customerRating;
        }

        public Object getDriverComment() {
            return driverComment;
        }

        public void setDriverComment(Object driverComment) {
            this.driverComment = driverComment;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }

        public Object getBarcode() {
            return barcode;
        }

        public void setBarcode(Object barcode) {
            this.barcode = barcode;
        }

        public Integer getRideType() {
            return rideType;
        }

        public void setRideType(Integer rideType) {
            this.rideType = rideType;
        }

        public Object getMatchedPickupDeliveryRelationship() {
            return matchedPickupDeliveryRelationship;
        }

        public void setMatchedPickupDeliveryRelationship(Object matchedPickupDeliveryRelationship) {
            this.matchedPickupDeliveryRelationship = matchedPickupDeliveryRelationship;
        }

        public List<Object> getCustomField() {
            return customField;
        }

        public void setCustomField(List<Object> customField) {
            this.customField = customField;
        }

        public String getTrackingLink() {
            return trackingLink;
        }

        public void setTrackingLink(String trackingLink) {
            this.trackingLink = trackingLink;
        }

    }
}