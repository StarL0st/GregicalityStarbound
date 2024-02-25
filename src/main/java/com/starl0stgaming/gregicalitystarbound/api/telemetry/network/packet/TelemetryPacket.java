package com.starl0stgaming.gregicalitystarbound.api.telemetry.network.packet;

import com.starl0stgaming.gregicalitystarbound.api.telemetry.network.packet.data.TelemetryPacketPayload;

public class TelemetryPacket {

    private int priority;
    //gets cleared after each send operation is completed, if value equals 0 then it will be sent to whole connection;
    private int destinationID;
    private TelemetryPacketPayload packetPayload;

    public TelemetryPacket() {
        this.priority = priority;
    }


    public TelemetryPacketPayload getPacketPayload() {
        return packetPayload;
    }

    public void setPacketPayload(TelemetryPacketPayload packetPayload) {
        this.packetPayload = packetPayload;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(int destinationID) {
        this.destinationID = destinationID;
    }
}
