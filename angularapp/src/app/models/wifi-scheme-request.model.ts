export interface WifiSchemeRequest {
    wifiSchemeRequestId?:number;
    userId:number;
    wifiSchemeId:number;
    requestDate:Date;
    status:string;
    comments:string;
    proof:string;
    streetName:string;
    landmark:string;
    city:string;
    state:string;
    zipCode:string;
    preferredSetupDate:Date;
    timeSlot:string;
}
