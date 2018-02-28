import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ComputestTestje3 extends Simulation {

	val httpProtocol = http
		.baseURL("https://computest.nl")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("nl,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:58.0) Gecko/20100101 Firefox/58.0")
    
	val scn1 = scenario("ComputestTestje3a").repeat(3) {
	group("UC1_00_Homepage")	{
    // Loadpage
    exec(http("homepage")
         .get("/")
         .check(substring("Wij hebben").exists) 
         .check(status.not(404),  status.not(500))
        .check(status.is(200)))
        .pause(6,18) }
    .group("UC1_01_Actueel")	{
    // Actueel
    exec(http("actueel")
         .get("/nieuws-persberichten/")
         .check(substring("Nieuws").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
    .group("UC1_02_OverOns")	{
    // Over Ons
        exec(http("overons")
         .get("/over-ons/")
         .check(substring("Over ons").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC1_03_Contact")	{
    // Contact
        exec(http("contact")
         .get("/contact/")
         .check(substring("Contact").exists)
         .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC1_04_Whitepapers")	{
    // Contact
        exec(http("whitepapers")
         .get("/onze-whitepapers/")
         .check(substring("Onze whitepapers").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC1_05_FunctioneelTesten")	{
    // Contact
        exec(http("/functioneeltesten/")
         .get("/functioneel-testen/")
         .check(substring("Geautomatiseerd functioneel testen").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC1_06_Introductie")	{
    // Contact
        exec(http("introductie")
         .get("/introduction-into-security-testing/")
         .check(substring("Introduction").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,181) }}
    
    val scn2 = scenario("ComputestTestje3b").repeat(2) {
	group("UC2_00_Homepage")	{
    // Loadpage
    exec(http("homepage")
         .get("/")
         .check(substring("Wij hebben").exists) 
         .check(status.not(404),  status.not(500))
        .check(status.is(200)))
        .pause(6,18) }
    .group("UC2_01_Actueel")	{
    // Actueel
    exec(http("actueel")
         .get("/nieuws-persberichten/")
         .check(substring("Nieuws").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
    .group("UC2_02_OverOns")	{
    // Over Ons
        exec(http("overons")
         .get("/over-ons/")
         .check(substring("Over ons").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC2_03_Contact")	{
    // Contact
        exec(http("contact")
         .get("/contact/")
         .check(substring("Contact").exists)
         .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC2_04_Whitepapers")	{
    // Contact
        exec(http("whitepapers")
         .get("/onze-whitepapers/")
         .check(substring("Onze whitepapers").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC2_05_FunctioneelTesten")	{
    // Contact
        exec(http("/functioneeltesten/")
         .get("/functioneel-testen/")
         .check(substring("Geautomatiseerd functioneel testen").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,18) }
     .group("UC2_06_Introductie")	{
    // Contact
        exec(http("introductie")
         .get("/introduction-into-security-testing/")
         .check(substring("Introduction").exists)
        .check(status.not(404))
        .check(status.is(200)))
        .pause(6,181) }}
setUp(scn1.inject(rampUsers(15) over (60 seconds)), scn2.inject(rampUsers(25) over (100 seconds))).protocols(httpProtocol).maxDuration(60 minutes)
    
    
        
}