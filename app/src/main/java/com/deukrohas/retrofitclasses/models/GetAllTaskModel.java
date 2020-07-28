package com.deukrohas.retrofitclasses.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllTaskModel {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("total_page_count")
    @Expose
    private Integer totalPageCount;
    @SerializedName("requested_page")
    @Expose
    private Integer requestedPage;
    @SerializedName("records_per_page")
    @Expose
    private Integer recordsPerPage;

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

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getRequestedPage() {
        return requestedPage;
    }

    public void setRequestedPage(Integer requestedPage) {
        this.requestedPage = requestedPage;
    }

    public Integer getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(Integer recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public class Datum {

        @SerializedName("fleet_id")
        @Expose
        private Integer fleetId;
        @SerializedName("fleet_name")
        @Expose
        private String fleetName;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("job_pickup_name")
        @Expose
        private String jobPickupName;
        @SerializedName("job_pickup_phone")
        @Expose
        private String jobPickupPhone;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("job_latitude")
        @Expose
        private String jobLatitude;
        @SerializedName("job_longitude")
        @Expose
        private String jobLongitude;
        @SerializedName("job_address")
        @Expose
        private String jobAddress;
        @SerializedName("job_status")
        @Expose
        private Integer jobStatus;
        @SerializedName("job_description")
        @Expose
        private String jobDescription;
        @SerializedName("has_pickup")
        @Expose
        private Integer hasPickup;
        @SerializedName("pickup_delivery_relationship")
        @Expose
        private String pickupDeliveryRelationship;
        @SerializedName("completed_by_admin")
        @Expose
        private Integer completedByAdmin;
        @SerializedName("job_pickup_datetime")
        @Expose
        private String jobPickupDatetime;
        @SerializedName("job_id")
        @Expose
        private Integer jobId;
        @SerializedName("job_delivery_datetime")
        @Expose
        private String jobDeliveryDatetime;
        @SerializedName("job_type")
        @Expose
        private Integer jobType;
        @SerializedName("creation_datetime")
        @Expose
        private String creationDatetime;
        @SerializedName("job_pickup_latitude")
        @Expose
        private String jobPickupLatitude;
        @SerializedName("job_pickup_longitude")
        @Expose
        private String jobPickupLongitude;
        @SerializedName("job_pickup_address")
        @Expose
        private String jobPickupAddress;
        @SerializedName("customer_id")
        @Expose
        private Integer customerId;
        @SerializedName("customer_username")
        @Expose
        private String customerUsername;
        @SerializedName("customer_phone")
        @Expose
        private String customerPhone;
        @SerializedName("customer_email")
        @Expose
        private String customerEmail;
        @SerializedName("days_started")
        @Expose
        private String daysStarted;
        @SerializedName("started_datetime")
        @Expose
        private String startedDatetime;
        @SerializedName("completed_datetime")
        @Expose
        private String completedDatetime;
        @SerializedName("acknowledged_datetime")
        @Expose
        private String acknowledgedDatetime;
        @SerializedName("arrived_datetime")
        @Expose
        private String arrivedDatetime;
        @SerializedName("total_distance_travelled")
        @Expose
        private Object totalDistanceTravelled;
        @SerializedName("team_id")
        @Expose
        private Integer teamId;
        @SerializedName("fleet_rating")
        @Expose
        private Integer fleetRating;

        public Integer getFleetId() {
            return fleetId;
        }

        public void setFleetId(Integer fleetId) {
            this.fleetId = fleetId;
        }

        public String getFleetName() {
            return fleetName;
        }

        public void setFleetName(String fleetName) {
            this.fleetName = fleetName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
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

        public String getJobAddress() {
            return jobAddress;
        }

        public void setJobAddress(String jobAddress) {
            this.jobAddress = jobAddress;
        }

        public Integer getJobStatus() {
            return jobStatus;
        }

        public void setJobStatus(Integer jobStatus) {
            this.jobStatus = jobStatus;
        }

        public String getJobDescription() {
            return jobDescription;
        }

        public void setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
        }

        public Integer getHasPickup() {
            return hasPickup;
        }

        public void setHasPickup(Integer hasPickup) {
            this.hasPickup = hasPickup;
        }

        public String getPickupDeliveryRelationship() {
            return pickupDeliveryRelationship;
        }

        public void setPickupDeliveryRelationship(String pickupDeliveryRelationship) {
            this.pickupDeliveryRelationship = pickupDeliveryRelationship;
        }

        public Integer getCompletedByAdmin() {
            return completedByAdmin;
        }

        public void setCompletedByAdmin(Integer completedByAdmin) {
            this.completedByAdmin = completedByAdmin;
        }

        public String getJobPickupDatetime() {
            return jobPickupDatetime;
        }

        public void setJobPickupDatetime(String jobPickupDatetime) {
            this.jobPickupDatetime = jobPickupDatetime;
        }

        public Integer getJobId() {
            return jobId;
        }

        public void setJobId(Integer jobId) {
            this.jobId = jobId;
        }

        public String getJobDeliveryDatetime() {
            return jobDeliveryDatetime;
        }

        public void setJobDeliveryDatetime(String jobDeliveryDatetime) {
            this.jobDeliveryDatetime = jobDeliveryDatetime;
        }

        public Integer getJobType() {
            return jobType;
        }

        public void setJobType(Integer jobType) {
            this.jobType = jobType;
        }

        public String getCreationDatetime() {
            return creationDatetime;
        }

        public void setCreationDatetime(String creationDatetime) {
            this.creationDatetime = creationDatetime;
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

        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public String getCustomerUsername() {
            return customerUsername;
        }

        public void setCustomerUsername(String customerUsername) {
            this.customerUsername = customerUsername;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getDaysStarted() {
            return daysStarted;
        }

        public void setDaysStarted(String daysStarted) {
            this.daysStarted = daysStarted;
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

        public String getArrivedDatetime() {
            return arrivedDatetime;
        }

        public void setArrivedDatetime(String arrivedDatetime) {
            this.arrivedDatetime = arrivedDatetime;
        }

        public Object getTotalDistanceTravelled() {
            return totalDistanceTravelled;
        }

        public void setTotalDistanceTravelled(Object totalDistanceTravelled) {
            this.totalDistanceTravelled = totalDistanceTravelled;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

        public Integer getFleetRating() {
            return fleetRating;
        }

        public void setFleetRating(Integer fleetRating) {
            this.fleetRating = fleetRating;
        }

    }

}