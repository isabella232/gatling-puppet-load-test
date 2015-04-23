package com.puppetlabs.gatling.simulation

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
// import io.gatling.jdbc.Predef._
import com.puppetlabs.gatling.runner.SimulationWithScenario
import org.joda.time.LocalDateTime
import org.joda.time.format.ISODateTimeFormat

class PE372_CatalogZero extends SimulationWithScenario {

//	val httpProtocol = http
//		.baseURL("https://perf-bl15.delivery.puppetlabs.net:8140")
//		.acceptHeader("pson, b64_zlib_yaml, yaml, raw")
//		.acceptEncodingHeader("identity")
//		.contentTypeHeader("application/x-www-form-urlencoded")
//		.userAgentHeader("Ruby")

	val headers_3 = Map("Accept" -> "pson, b64_zlib_yaml, yaml, dot, raw")

	val headers_106 = Map(
		"Accept" -> "pson, yaml",
		"Content-Type" -> "text/pson", // add Connection Close...
		"Connection" -> "close")

//    val uri1 = "https://perf-bl15.delivery.puppetlabs.net:8140/production"

val reportBody = ELFileBody("PE372_CatalogZero_requiest.txt")

	val chain_0 = exec(http("request_0")
			.get("/production/node/rxgin3yubplp14r.delivery.puppetlabs.net?transaction_uuid=099ea391-5fa5-4e82-bc95-0190c927a362&fail_on_404=true"))
		.exec(http("request_1")
			.get("/production/file_metadatas/pluginfacts?links=manage&recurse=true&ignore=.svn&ignore=CVS&ignore=.git&checksum_type=md5"))
		.pause(364 milliseconds)
		.exec(http("request_2")
			.get("/production/file_metadatas/plugins?links=manage&recurse=true&ignore=.svn&ignore=CVS&ignore=.git&checksum_type=md5"))
		.pause(739 milliseconds)
		.exec(http("request_3")
			.post("/production/catalog/rxgin3yubplp14r.delivery.puppetlabs.net")
			.headers(headers_3)
			.formParam("facts_format", "pson")
			.formParam("facts", "%7B%22name%22%3A%22rxgin3yubplp14r.delivery.puppetlabs.net%22%2C%22values%22%3A%7B%22netmask%22%3A%22255.255.240.0%22%2C%22rubysitedir%22%3A%22%2Fopt%2Fpuppet%2Flib%2Fruby%2Fsite_ruby%2F1.9.1%22%2C%22kernelversion%22%3A%222.6.32%22%2C%22memorysize%22%3A%223.74+GB%22%2C%22memoryfree%22%3A%223.43+GB%22%2C%22swapsize%22%3A%223.94+GB%22%2C%22swapfree%22%3A%223.94+GB%22%2C%22swapsize_mb%22%3A%224031.99%22%2C%22swapfree_mb%22%3A%224031.99%22%2C%22memorysize_mb%22%3A%223832.70%22%2C%22memoryfree_mb%22%3A%223514.98%22%2C%22kernel%22%3A%22Linux%22%2C%22virtual%22%3A%22vmware%22%2C%22is_virtual%22%3Atrue%2C%22operatingsystem%22%3A%22RedHat%22%2C%22uptime%22%3A%2212%3A03+hours%22%2C%22filesystems%22%3A%22ext4%2Ciso9660%22%2C%22hardwareisa%22%3A%22x86_64%22%2C%22kernelrelease%22%3A%222.6.32-431.11.2.el6.x86_64%22%2C%22uniqueid%22%3A%22200a5479%22%2C%22macaddress%22%3A%2200%3A50%3A56%3A8F%3A5D%3AAD%22%2C%22uptime_seconds%22%3A43419%2C%22processors%22%3A%7B%22models%22%3A%5B%22Intel%28R%29+Xeon%28R%29+CPU+E5-2680+v2+%40+2.80GHz%22%2C%22Intel%28R%29+Xeon%28R%29+CPU+E5-2680+v2+%40+2.80GHz%22%5D%2C%22count%22%3A2%2C%22physicalcount%22%3A2%7D%2C%22architecture%22%3A%22x86_64%22%2C%22hardwaremodel%22%3A%22x86_64%22%2C%22os%22%3A%7B%22name%22%3A%22RedHat%22%2C%22family%22%3A%22RedHat%22%2C%22release%22%3A%7B%22major%22%3A%226%22%2C%22minor%22%3A%225%22%2C%22full%22%3A%226.5%22%7D%7D%2C%22processor0%22%3A%22Intel%28R%29+Xeon%28R%29+CPU+E5-2680+v2+%40+2.80GHz%22%2C%22processor1%22%3A%22Intel%28R%29+Xeon%28R%29+CPU+E5-2680+v2+%40+2.80GHz%22%2C%22processorcount%22%3A2%2C%22physicalprocessorcount%22%3A2%2C%22boardmanufacturer%22%3A%22Intel+Corporation%22%2C%22boardproductname%22%3A%22440BX+Desktop+Reference+Platform%22%2C%22boardserialnumber%22%3A%22None%22%2C%22bios_vendor%22%3A%22Phoenix+Technologies+LTD%22%2C%22bios_version%22%3A%226.00%22%2C%22bios_release_date%22%3A%2207%2F30%2F2013%22%2C%22manufacturer%22%3A%22VMware%2C+Inc.%22%2C%22productname%22%3A%22VMware+Virtual+Platform%22%2C%22serialnumber%22%3A%22VMware-42+0f+f2+ce+48+f7+55+20-ad+55+cf+d1+1f+47+c6+b9%22%2C%22uuid%22%3A%22420FF2CE-48F7-5520-AD55-CFD11F47C6B9%22%2C%22type%22%3A%22Other%22%2C%22interfaces%22%3A%22eth0%2Clo%22%2C%22ipaddress_eth0%22%3A%2210.32.121.84%22%2C%22macaddress_eth0%22%3A%2200%3A50%3A56%3A8F%3A5D%3AAD%22%2C%22netmask_eth0%22%3A%22255.255.240.0%22%2C%22mtu_eth0%22%3A1500%2C%22ipaddress_lo%22%3A%22127.0.0.1%22%2C%22netmask_lo%22%3A%22255.0.0.0%22%2C%22mtu_lo%22%3A16436%2C%22ipaddress%22%3A%2210.32.121.84%22%2C%22uptime_days%22%3A0%2C%22network_eth0%22%3A%2210.32.112.0%22%2C%22network_lo%22%3A%22127.0.0.0%22%2C%22fqdn%22%3A%22rxgin3yubplp14r.delivery.puppetlabs.net%22%2C%22augeasversion%22%3A%221.2.0%22%2C%22rubyversion%22%3A%221.9.3%22%2C%22system_uptime%22%3A%7B%22seconds%22%3A43419%2C%22hours%22%3A12%2C%22days%22%3A0%2C%22uptime%22%3A%2212%3A03+hours%22%7D%2C%22facterversion%22%3A%222.3.0%22%2C%22sshdsakey%22%3A%22AAAAB3NzaC1kc3MAAACBAL%2FkJrTFWpmGlMFf2GHYO2Ws3CdDvvrOLWFkJOrn9fmy%2BLPD4%2BydxHkK9%2BfzeJAgcSznpQH3RB1ckTow%2FtyOodZxgS4fbIXanCVVeRn3CSSknjMI7YliQSV2cjmAhqRr99w6FMOmUASAFW%2B%2BuaW0lS3g5pImxAPCo8RKVziMNqQtAAAAFQDhhNOkYTtlF8eguTaC5ldwq0GJjQAAAIEAsXBSy%2BEriBji4kcRaEyWSkNEqdaIAxc5bigdt7qR0LcsZ%2BLKEuHbRkR4MKRchi8NjQv2ihhCn6pEQ30Or3q%2FnPxnmUqnVZKdtk84f%2BgGvW2mCUeKVHyS8hOcayTWUC%2BOctv%2FBllIisNzZjfPTMEDf9JB9yWGpFBE4edfmT0EDNsAAACBAJDpmsi6wBfAkFZPSSbzbiM%2FXMoCazNpdPZ7zM9He3fFeKbkJfZ6lPGeOYFXsADaTlJcgJMLuzKH1R3f2ViQkvNLNgb24ItpqI0Z2S8HA%2Bl0qChN79l8LHuHiEvvfikTmEOKQblG58DlMcYUN%2BLNA8lx55e2rmbIZXGSx%2FMWpTuO%22%2C%22sshfp_dsa%22%3A%22SSHFP+2+1+b990d610e1f0cc9df9c147e2a55905a9f3de6962%5CnSSHFP+2+2+3150eb2cda72544aa95d48f9603f58e9f5c47491d45b0664483ac41857f6ef5b%22%2C%22sshrsakey%22%3A%22AAAAB3NzaC1yc2EAAAABIwAAAQEAuhiwRn5SsCBebNiMClCjpA2Hl4bLg5juyNkFsFqm%2FXGNYKoF4H1f%2BihhzPEJzwPxYxDMFlq0OHEFIEZwt6vrf2JXWDXCayNpFqzHDybf%2BNDqSxCG6XL28Bzxr3kOVXaSLrtcVdtSa%2FshmB4cXXyFRHHIot6bSlZLbdNYuhlKmP8QIbVaspClkB%2FF2V4OjnV5%2F366CQSoYlzBV7KoWOD3vcQUZDB1bt6vxQOdzlBQJAmhdbAlkHJz2F6oi6niZgb21iv%2BsWkAV5%2BUM9aJDrKB%2Bhz72o0pOUxKhPLtmf1THh%2Be3xjijjNJnjsUApaki6pTd7xjsBKfiNM%2BAVnFrob18Q%3D%3D%22%2C%22sshfp_rsa%22%3A%22SSHFP+1+1+1a5e813e79a52ca3d9994e6d1b873a224c02cad1%5CnSSHFP+1+2+5ea4c7570b1297ef108a647449cd77a9c66164a5053451c7e535bfc1bd99b169%22%2C%22domain%22%3A%22delivery.puppetlabs.net%22%2C%22uptime_hours%22%3A12%2C%22ps%22%3A%22ps+-ef%22%2C%22blockdevice_sr0_size%22%3A1073741312%2C%22blockdevice_sr0_vendor%22%3A%22NECVMWar%22%2C%22blockdevice_sr0_model%22%3A%22VMware+IDE+CDR10%22%2C%22blockdevice_sda_size%22%3A8589934592%2C%22blockdevice_sda_vendor%22%3A%22VMware%22%2C%22blockdevice_sda_model%22%3A%22Virtual+disk%22%2C%22blockdevice_sdb_size%22%3A8589934592%2C%22blockdevice_sdb_vendor%22%3A%22VMware%22%2C%22blockdevice_sdb_model%22%3A%22Virtual+disk%22%2C%22blockdevices%22%3A%22sda%2Csdb%2Csr0%22%2C%22hostname%22%3A%22rxgin3yubplp14r%22%2C%22selinux%22%3Atrue%2C%22selinux_enforced%22%3Atrue%2C%22selinux_policyversion%22%3A%2224%22%2C%22selinux_current_mode%22%3A%22enforcing%22%2C%22selinux_config_mode%22%3A%22enforcing%22%2C%22selinux_config_policy%22%3A%22targeted%22%2C%22path%22%3A%22%2Fopt%2Fpuppet%2Fbin%3A%2Fusr%2Flocal%2Fsbin%3A%2Fusr%2Flocal%2Fbin%3A%2Fsbin%3A%2Fbin%3A%2Fusr%2Fsbin%3A%2Fusr%2Fbin%3A%2Froot%2Fbin%22%2C%22timezone%22%3A%22PDT%22%2C%22osfamily%22%3A%22RedHat%22%2C%22operatingsystemmajrelease%22%3A%226%22%2C%22operatingsystemrelease%22%3A%226.5%22%2C%22rubyplatform%22%3A%22x86_64-linux%22%2C%22gid%22%3A%22root%22%2C%22puppetversion%22%3A%223.7.4+%28Puppet+Enterprise+3.7.2%29%22%2C%22kernelmajversion%22%3A%222.6%22%2C%22partitions%22%3A%7B%22sda1%22%3A%7B%22uuid%22%3A%22eb475619-f4b3-41af-91ca-b37fec3374d7%22%2C%22size%22%3A%221024000%22%2C%22mount%22%3A%22%2Fboot%22%2C%22filesystem%22%3A%22ext4%22%7D%2C%22sda2%22%3A%7B%22size%22%3A%2215751168%22%2C%22filesystem%22%3A%22LVM2_member%22%7D%2C%22sdb1%22%3A%7B%22size%22%3A%2216777184%22%2C%22filesystem%22%3A%22LVM2_member%22%7D%7D%2C%22id%22%3A%22root%22%2C%22staging_http_get%22%3A%22curl%22%2C%22pe_concat_basedir%22%3A%22%2Fvar%2Fopt%2Flib%2Fpe-puppet%2Fpe_concat%22%2C%22pe_build%22%3A%223.7.2%22%2C%22platform_tag%22%3A%22el-6-x86_64%22%2C%22custom_auth_conf%22%3A%22false%22%2C%22pe_version%22%3A%223.7.2%22%2C%22is_pe%22%3Atrue%2C%22pe_major_version%22%3A%223%22%2C%22pe_minor_version%22%3A%227%22%2C%22pe_patch_version%22%3A%222%22%2C%22clientcert%22%3A%22rxgin3yubplp14r.delivery.puppetlabs.net%22%2C%22clientversion%22%3A%223.7.4+%28Puppet+Enterprise+3.7.2%29%22%2C%22clientnoop%22%3Afalse%7D%2C%22timestamp%22%3A%222015-04-22+16%3A48%3A33+-0700%22%2C%22expiration%22%3A%222015-04-22T17%3A18%3A33.315862585-07%3A00%22%7D")
			.formParam("transaction_uuid", "099ea391-5fa5-4e82-bc95-0190c927a362")
			.formParam("fail_on_404", "true"))
		.pause(2)
		.exec(http("request_4")
			.get("/production/file_metadata/modules/catalog-zero1/catalog-zero1-impl24.txt?links=manage&source_permissions=use"))
		.exec(http("request_5")
			.get("/production/file_metadata/modules/catalog-zero1/catalog-zero1-impl71.txt?links=manage&source_permissions=use"))
		.exec(http("request_6")
			.get("/production/file_metadata/modules/catalog-zero1/catalog-zero1-impl83.txt?links=manage&source_permissions=use"))
		.exec(http("request_7")
			.get("/production/file_metadata/modules/catalog-zero2/catalog-zero2-impl51.txt?links=manage&source_permissions=use"))
		.exec(http("request_8")
			.get("/production/file_metadata/modules/catalog-zero3/catalog-zero3-impl23.txt?links=manage&source_permissions=use"))
		.exec(http("request_9")
			.get("/production/file_metadata/modules/catalog-zero3/catalog-zero3-impl32.txt?links=manage&source_permissions=use"))
		.exec(http("request_10")
			.get("/production/file_metadata/modules/catalog-zero3/catalog-zero3-impl74.txt?links=manage&source_permissions=use"))
		.exec(http("request_11")
			.get("/production/file_metadata/modules/catalog-zero4/catalog-zero4-impl13.txt?links=manage&source_permissions=use"))
		.exec(http("request_12")
			.get("/production/file_metadata/modules/catalog-zero5/catalog-zero5-impl22.txt?links=manage&source_permissions=use"))
		.exec(http("request_13")
			.get("/production/file_metadata/modules/catalog-zero5/catalog-zero5-impl42.txt?links=manage&source_permissions=use"))
		.exec(http("request_14")
			.get("/production/file_metadata/modules/catalog-zero5/catalog-zero5-impl43.txt?links=manage&source_permissions=use"))
		.exec(http("request_15")
			.get("/production/file_metadata/modules/catalog-zero5/catalog-zero5-impl52.txt?links=manage&source_permissions=use"))
		.exec(http("request_16")
			.get("/production/file_metadata/modules/catalog-zero6/catalog-zero6-impl32.txt?links=manage&source_permissions=use"))
		.exec(http("request_17")
			.get("/production/file_metadata/modules/catalog-zero6/catalog-zero6-impl54.txt?links=manage&source_permissions=use"))
		.exec(http("request_18")
			.get("/production/file_metadata/modules/catalog-zero7/catalog-zero7-impl32.txt?links=manage&source_permissions=use"))
		.exec(http("request_19")
			.get("/production/file_metadata/modules/catalog-zero7/catalog-zero7-impl34.txt?links=manage&source_permissions=use"))
		.exec(http("request_20")
			.get("/production/file_metadata/modules/catalog-zero7/catalog-zero7-impl82.txt?links=manage&source_permissions=use"))
		.exec(http("request_21")
			.get("/production/file_metadata/modules/catalog-zero7/catalog-zero7-impl85.txt?links=manage&source_permissions=use"))
		.exec(http("request_22")
			.get("/production/file_metadata/modules/catalog-zero7/catalog-zero7-impl87.txt?links=manage&source_permissions=use"))
		.exec(http("request_23")
			.get("/production/file_metadata/modules/catalog-zero8/catalog-zero8-impl11.txt?links=manage&source_permissions=use"))
		.exec(http("request_24")
			.get("/production/file_metadata/modules/catalog-zero8/catalog-zero8-impl13.txt?links=manage&source_permissions=use"))
		.exec(http("request_25")
			.get("/production/file_metadata/modules/catalog-zero8/catalog-zero8-impl33.txt?links=manage&source_permissions=use"))
		.exec(http("request_26")
			.get("/production/file_metadata/modules/catalog-zero8/catalog-zero8-impl81.txt?links=manage&source_permissions=use"))
		.exec(http("request_27")
			.get("/production/file_metadata/modules/catalog-zero9/catalog-zero9-impl63.txt?links=manage&source_permissions=use"))
		.exec(http("request_28")
			.get("/production/file_metadata/modules/catalog-zero9/catalog-zero9-impl72.txt?links=manage&source_permissions=use"))
		.exec(http("request_29")
			.get("/production/file_metadata/modules/catalog-zero9/catalog-zero9-impl84.txt?links=manage&source_permissions=use"))
		.exec(http("request_30")
			.get("/production/file_metadata/modules/catalog-zero10/catalog-zero10-impl13.txt?links=manage&source_permissions=use"))
		.exec(http("request_31")
			.get("/production/file_metadata/modules/catalog-zero10/catalog-zero10-impl22.txt?links=manage&source_permissions=use"))
		.exec(http("request_32")
			.get("/production/file_metadata/modules/catalog-zero10/catalog-zero10-impl41.txt?links=manage&source_permissions=use"))
		.exec(http("request_33")
			.get("/production/file_metadata/modules/catalog-zero10/catalog-zero10-impl71.txt?links=manage&source_permissions=use"))
		.exec(http("request_34")
			.get("/production/file_metadata/modules/catalog-zero10/catalog-zero10-impl83.txt?links=manage&source_permissions=use"))
		.exec(http("request_35")
			.get("/production/file_metadata/modules/catalog-zero10/catalog-zero10-impl85.txt?links=manage&source_permissions=use"))
		.exec(http("request_36")
			.get("/production/file_metadata/modules/catalog-zero11/catalog-zero11-impl11.txt?links=manage&source_permissions=use"))
		.exec(http("request_37")
			.get("/production/file_metadata/modules/catalog-zero11/catalog-zero11-impl21.txt?links=manage&source_permissions=use"))
		.exec(http("request_38")
			.get("/production/file_metadata/modules/catalog-zero11/catalog-zero11-impl24.txt?links=manage&source_permissions=use"))
		.exec(http("request_39")
			.get("/production/file_metadata/modules/catalog-zero11/catalog-zero11-impl62.txt?links=manage&source_permissions=use"))
		.exec(http("request_40")
			.get("/production/file_metadata/modules/catalog-zero11/catalog-zero11-impl84.txt?links=manage&source_permissions=use"))
		.exec(http("request_41")
			.get("/production/file_metadata/modules/catalog-zero12/catalog-zero12-impl33.txt?links=manage&source_permissions=use"))
		.exec(http("request_42")
			.get("/production/file_metadata/modules/catalog-zero12/catalog-zero12-impl82.txt?links=manage&source_permissions=use"))
		.exec(http("request_43")
			.get("/production/file_metadata/modules/catalog-zero12/catalog-zero12-impl86.txt?links=manage&source_permissions=use"))
		.exec(http("request_44")
			.get("/production/file_metadata/modules/catalog-zero12/catalog-zero12-impl87.txt?links=manage&source_permissions=use"))
		.exec(http("request_45")
			.get("/production/file_metadata/modules/catalog-zero13/catalog-zero13-impl51.txt?links=manage&source_permissions=use"))
		.exec(http("request_46")
			.get("/production/file_metadata/modules/catalog-zero13/catalog-zero13-impl54.txt?links=manage&source_permissions=use"))
		.exec(http("request_47")
			.get("/production/file_metadata/modules/catalog-zero13/catalog-zero13-impl74.txt?links=manage&source_permissions=use"))
		.exec(http("request_48")
			.get("/production/file_metadata/modules/catalog-zero13/catalog-zero13-impl83.txt?links=manage&source_permissions=use"))
		.exec(http("request_49")
			.get("/production/file_metadata/modules/catalog-zero13/catalog-zero13-impl84.txt?links=manage&source_permissions=use"))
		.exec(http("request_50")
			.get("/production/file_metadata/modules/catalog-zero13/catalog-zero13-impl86.txt?links=manage&source_permissions=use"))
		.exec(http("request_51")
			.get("/production/file_metadata/modules/catalog-zero14/catalog-zero14-impl72.txt?links=manage&source_permissions=use"))
		.exec(http("request_52")
			.get("/production/file_metadata/modules/catalog-zero15/catalog-zero15-impl62.txt?links=manage&source_permissions=use"))
		.exec(http("request_53")
			.get("/production/file_metadata/modules/catalog-zero15/catalog-zero15-impl72.txt?links=manage&source_permissions=use"))
		.exec(http("request_54")
			.get("/production/file_metadata/modules/catalog-zero15/catalog-zero15-impl73.txt?links=manage&source_permissions=use"))
		.exec(http("request_55")
			.get("/production/file_metadata/modules/catalog-zero16/catalog-zero16-impl33.txt?links=manage&source_permissions=use"))
		.exec(http("request_56")
			.get("/production/file_metadata/modules/catalog-zero16/catalog-zero16-impl83.txt?links=manage&source_permissions=use"))
		.exec(http("request_57")
			.get("/production/file_metadata/modules/catalog-zero16/catalog-zero16-impl85.txt?links=manage&source_permissions=use"))
		.exec(http("request_58")
			.get("/production/file_metadata/modules/catalog-zero17/catalog-zero17-impl13.txt?links=manage&source_permissions=use"))
		.exec(http("request_59")
			.get("/production/file_metadata/modules/catalog-zero17/catalog-zero17-impl87.txt?links=manage&source_permissions=use"))
		.exec(http("request_60")
			.get("/production/file_metadata/modules/catalog-zero18/catalog-zero18-impl14.txt?links=manage&source_permissions=use"))
		.exec(http("request_61")
			.get("/production/file_metadata/modules/catalog-zero18/catalog-zero18-impl23.txt?links=manage&source_permissions=use"))
		.exec(http("request_62")
			.get("/production/file_metadata/modules/catalog-zero18/catalog-zero18-impl24.txt?links=manage&source_permissions=use"))
		.exec(http("request_63")
			.get("/production/file_metadata/modules/catalog-zero18/catalog-zero18-impl32.txt?links=manage&source_permissions=use"))
		.exec(http("request_64")
			.get("/production/file_metadata/modules/catalog-zero18/catalog-zero18-impl84.txt?links=manage&source_permissions=use"))
		.exec(http("request_65")
			.get("/production/file_metadata/modules/catalog-zero19/catalog-zero19-impl12.txt?links=manage&source_permissions=use"))
		.exec(http("request_66")
			.get("/production/file_metadata/modules/catalog-zero19/catalog-zero19-impl31.txt?links=manage&source_permissions=use"))
		.exec(http("request_67")
			.get("/production/file_metadata/modules/catalog-zero19/catalog-zero19-impl53.txt?links=manage&source_permissions=use"))
		.exec(http("request_68")
			.get("/production/file_metadata/modules/catalog-zero19/catalog-zero19-impl54.txt?links=manage&source_permissions=use"))
		.exec(http("request_69")
			.get("/production/file_metadata/modules/catalog-zero19/catalog-zero19-impl83.txt?links=manage&source_permissions=use"))
		.exec(http("request_70")
			.get("/production/file_metadata/modules/catalog-zero19/catalog-zero19-impl86.txt?links=manage&source_permissions=use"))
		.exec(http("request_71")
			.get("/production/file_metadata/modules/catalog-zero20/catalog-zero20-impl24.txt?links=manage&source_permissions=use"))
		.exec(http("request_72")
			.get("/production/file_metadata/modules/catalog-zero20/catalog-zero20-impl42.txt?links=manage&source_permissions=use"))
		.exec(http("request_73")
			.get("/production/file_metadata/modules/catalog-zero20/catalog-zero20-impl71.txt?links=manage&source_permissions=use"))
		.exec(http("request_74")
			.get("/production/file_metadata/modules/catalog-zero20/catalog-zero20-impl73.txt?links=manage&source_permissions=use"))
		.exec(http("request_75")
			.get("/production/file_metadata/modules/catalog-zero21/catalog-zero21-impl32.txt?links=manage&source_permissions=use"))
		.exec(http("request_76")
			.get("/production/file_metadata/modules/catalog-zero21/catalog-zero21-impl41.txt?links=manage&source_permissions=use"))
		.exec(http("request_77")
			.get("/production/file_metadata/modules/catalog-zero21/catalog-zero21-impl82.txt?links=manage&source_permissions=use"))
		.exec(http("request_78")
			.get("/production/file_metadata/modules/catalog-zero21/catalog-zero21-impl86.txt?links=manage&source_permissions=use"))
		.exec(http("request_79")
			.get("/production/file_metadata/modules/catalog-zero21/catalog-zero21-impl87.txt?links=manage&source_permissions=use"))
		.exec(http("request_80")
			.get("/production/file_metadata/modules/catalog-zero22/catalog-zero22-impl34.txt?links=manage&source_permissions=use"))
		.exec(http("request_81")
			.get("/production/file_metadata/modules/catalog-zero22/catalog-zero22-impl52.txt?links=manage&source_permissions=use"))
		.exec(http("request_82")
			.get("/production/file_metadata/modules/catalog-zero23/catalog-zero23-impl21.txt?links=manage&source_permissions=use"))
		.exec(http("request_83")
			.get("/production/file_metadata/modules/catalog-zero23/catalog-zero23-impl62.txt?links=manage&source_permissions=use"))
		.exec(http("request_84")
			.get("/production/file_metadata/modules/catalog-zero24/catalog-zero24-impl52.txt?links=manage&source_permissions=use"))
		.exec(http("request_85")
			.get("/production/file_metadata/modules/catalog-zero24/catalog-zero24-impl83.txt?links=manage&source_permissions=use"))
		.exec(http("request_86")
			.get("/production/file_metadata/modules/catalog-zero25/catalog-zero25-impl13.txt?links=manage&source_permissions=use"))
		.exec(http("request_87")
			.get("/production/file_metadata/modules/catalog-zero25/catalog-zero25-impl22.txt?links=manage&source_permissions=use"))
		.exec(http("request_88")
			.get("/production/file_metadata/modules/catalog-zero25/catalog-zero25-impl24.txt?links=manage&source_permissions=use"))
		.exec(http("request_89")
			.get("/production/file_metadata/modules/catalog-zero25/catalog-zero25-impl51.txt?links=manage&source_permissions=use"))
		.exec(http("request_90")
			.get("/production/file_metadata/modules/catalog-zero26/catalog-zero26-impl54.txt?links=manage&source_permissions=use"))
		.exec(http("request_91")
			.get("/production/file_metadata/modules/catalog-zero26/catalog-zero26-impl64.txt?links=manage&source_permissions=use"))
		.exec(http("request_92")
			.get("/production/file_metadata/modules/catalog-zero26/catalog-zero26-impl86.txt?links=manage&source_permissions=use"))
		.exec(http("request_93")
			.get("/production/file_metadata/modules/catalog-zero27/catalog-zero27-impl33.txt?links=manage&source_permissions=use"))
		.exec(http("request_94")
			.get("/production/file_metadata/modules/catalog-zero27/catalog-zero27-impl41.txt?links=manage&source_permissions=use"))
		.exec(http("request_95")
			.get("/production/file_metadata/modules/catalog-zero27/catalog-zero27-impl63.txt?links=manage&source_permissions=use"))
		.exec(http("request_96")
			.get("/production/file_metadata/modules/catalog-zero28/catalog-zero28-impl13.txt?links=manage&source_permissions=use"))

val chain_1 = exec(http("request_97")
			.get("/production/file_metadata/modules/catalog-zero28/catalog-zero28-impl33.txt?links=manage&source_permissions=use"))
		.exec(http("request_98")
			.get("/production/file_metadata/modules/catalog-zero28/catalog-zero28-impl51.txt?links=manage&source_permissions=use"))
		.exec(http("request_99")
			.get("/production/file_metadata/modules/catalog-zero28/catalog-zero28-impl72.txt?links=manage&source_permissions=use"))
		.exec(http("request_100")
			.get("/production/file_metadata/modules/catalog-zero28/catalog-zero28-impl84.txt?links=manage&source_permissions=use"))
		.exec(http("request_101")
			.get("/production/file_metadata/modules/catalog-zero29/catalog-zero29-impl71.txt?links=manage&source_permissions=use"))
		.exec(http("request_102")
			.get("/production/file_metadata/modules/catalog-zero29/catalog-zero29-impl86.txt?links=manage&source_permissions=use"))
		.exec(http("request_103")
			.get("/production/file_metadata/modules/catalog-zero30/catalog-zero30-impl34.txt?links=manage&source_permissions=use"))
		.exec(http("request_104")
			.get("/production/file_metadata/modules/catalog-zero30/catalog-zero30-impl85.txt?links=manage&source_permissions=use"))
		.exec(http("request_105")
			.get("/production/file_metadatas/modules/puppet_enterprise/mcollective/plugins?links=manage&recurse=true&checksum_type=md5"))
		.pause(1)
.exec((session:Session) => {
      session.set("reportTimestamp",
        LocalDateTime.now.toString(ISODateTimeFormat.dateTime()))
    })
		.exec(http("report")
			.put("/production/report/rxgin3yubplp14r.delivery.puppetlabs.net")
			.headers(headers_106)
			.body(reportBody))
					
	val scn = scenario("PE372_CatalogZero").exec(
		chain_0, chain_1)

//	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
