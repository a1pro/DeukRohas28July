package com.deukrohas.retrofitclasses.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateDeliverTaskModel {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class Data {

        @SerializedName("job_id")
        @Expose
        private Integer jobId;
        @SerializedName("pickup_job_id")
        @Expose
        private Integer pickupJobId;
        @SerializedName("delivery_job_id")
        @Expose
        private Integer deliveryJobId;
        @SerializedName("job_hash")
        @Expose
        private String jobHash;
        @SerializedName("pickup_job_hash")
        @Expose
        private String pickupJobHash;
        @SerializedName("delivery_job_hash")
        @Expose
        private String deliveryJobHash;
        @SerializedName("customer_name")
        @Expose
        private String customerName;
        @SerializedName("customer_address")
        @Expose
        private String customerAddress;
        @SerializedName("job_pickup_name")
        @Expose
        private String jobPickupName;
        @SerializedName("job_pickup_address")
        @Expose
        private String jobPickupAddress;
        @SerializedName("job_token")
        @Expose
        private String jobToken;
        @SerializedName("pickup_tracking_link")
        @Expose
        private String pickupTrackingLink;
        @SerializedName("delivery_tracing_link")
        @Expose
        private String deliveryTracingLink;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("pickupOrderId")
        @Expose
        private String pickupOrderId;
        @SerializedName("deliveryOrderId")
        @Expose
        private String deliveryOrderId;
        @SerializedName("pickupAddressNotFound")
        @Expose
        private Boolean pickupAddressNotFound;
        @SerializedName("deliveryAddressNotFound")
        @Expose
        private Boolean deliveryAddressNotFound;

        public Integer getJobId() {
            return jobId;
        }

        public void setJobId(Integer jobId) {
            this.jobId = jobId;
        }

        public Integer getPickupJobId() {
            return pickupJobId;
        }

        public void setPickupJobId(Integer pickupJobId) {
            this.pickupJobId = pickupJobId;
        }

        public Integer getDeliveryJobId() {
            return deliveryJobId;
        }

        public void setDeliveryJobId(Integer deliveryJobId) {
            this.deliveryJobId = deliveryJobId;
        }

        public String getJobHash() {
            return jobHash;
        }

        public void setJobHash(String jobHash) {
            this.jobHash = jobHash;
        }

        public String getPickupJobHash() {
            return pickupJobHash;
        }

        public void setPickupJobHash(String pickupJobHash) {
            this.pickupJobHash = pickupJobHash;
        }

        public String getDeliveryJobHash() {
            return deliveryJobHash;
        }

        public void setDeliveryJobHash(String deliveryJobHash) {
            this.deliveryJobHash = deliveryJobHash;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public String getJobPickupName() {
            return jobPickupName;
        }

        public void setJobPickupName(String jobPickupName) {
            this.jobPickupName = jobPickupName;
        }

        public String getJobPickupAddress() {
            return jobPickupAddress;
        }

        public void setJobPickupAddress(String jobPickupAddress) {
            this.jobPickupAddress = jobPickupAddress;
        }

        public String getJobToken() {
            return jobToken;
        }

        public void setJobToken(String jobToken) {
            this.jobToken = jobToken;
        }

        public String getPickupTrackingLink() {
            return pickupTrackingLink;
        }

        public void setPickupTrackingLink(String pickupTrackingLink) {
            this.pickupTrackingLink = pickupTrackingLink;
        }

        public String getDeliveryTracingLink() {
            return deliveryTracingLink;
        }

        public void setDeliveryTracingLink(String deliveryTracingLink) {
            this.deliveryTracingLink = deliveryTracingLink;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getPickupOrderId() {
            return pickupOrderId;
        }

        public void setPickupOrderId(String pickupOrderId) {
            this.pickupOrderId = pickupOrderId;
        }

        public String getDeliveryOrderId() {
            return deliveryOrderId;
        }

        public void setDeliveryOrderId(String deliveryOrderId) {
            this.deliveryOrderId = deliveryOrderId;
        }

        public Boolean getPickupAddressNotFound() {
            return pickupAddressNotFound;
        }

        public void setPickupAddressNotFound(Boolean pickupAddressNotFound) {
            this.pickupAddressNotFound = pickupAddressNotFound;
        }

        public Boolean getDeliveryAddressNotFound() {
            return deliveryAddressNotFound;
        }

        public void setDeliveryAddressNotFound(Boolean deliveryAddressNotFound) {
            this.deliveryAddressNotFound = deliveryAddressNotFound;
        }

    }
}