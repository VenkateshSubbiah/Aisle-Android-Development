package com.aisle.pojo

import com.google.gson.annotations.SerializedName

data class NotesResponse(

	@field:SerializedName("invites")
	val invites: Invites? = null,

	@field:SerializedName("likes")
	val likes: Likes? = null
)

data class ProfileDataListItem(

	@field:SerializedName("preferences")
	val preferences: List<PreferencesItem?>? = null,

	@field:SerializedName("question")
	val question: String? = null,

	@field:SerializedName("invitation_type")
	val invitationType: String? = null
)

data class PhotosItem(

	@field:SerializedName("photo_id")
	val photoId: Int? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("selected")
	val selected: Boolean? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Faith(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class MotherTongue(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class ProfilesItem(

	@field:SerializedName("preferences")
	val preferences: List<PreferencesItem?>? = null,

	@field:SerializedName("lng")
	val lng: String? = null,

	@field:SerializedName("last_seen")
	val lastSeen: Any? = null,

	@field:SerializedName("work")
	val work: Work? = null,

	@field:SerializedName("last_seen_window")
	val lastSeenWindow: String? = null,

	@field:SerializedName("has_active_subscription")
	val hasActiveSubscription: Boolean? = null,

	@field:SerializedName("user_interests")
	val userInterests: List<Any?>? = null,

	@field:SerializedName("verification_status")
	val verificationStatus: String? = null,

	@field:SerializedName("photos")
	val photos: List<PhotosItem?>? = null,

	@field:SerializedName("show_concierge_badge")
	val showConciergeBadge: Boolean? = null,

	@field:SerializedName("approved_time")
	val approvedTime: Double? = null,

	@field:SerializedName("general_information")
	val generalInformation: GeneralInformation? = null,

	@field:SerializedName("profile_data_list")
	val profileDataList: List<ProfileDataListItem?>? = null,

	@field:SerializedName("instagram_images")
	val instagramImages: Any? = null,

	@field:SerializedName("disapproved_time")
	val disapprovedTime: Double? = null,

	@field:SerializedName("online_code")
	val onlineCode: Int? = null,

	@field:SerializedName("is_facebook_data_fetched")
	val isFacebookDataFetched: Boolean? = null,

	@field:SerializedName("icebreakers")
	val icebreakers: Any? = null,

	@field:SerializedName("meetup")
	val meetup: Any? = null,

	@field:SerializedName("lat")
	val lat: String? = null,

	@field:SerializedName("story")
	val story: Any? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null
)

data class Work(

	@field:SerializedName("experience_v1")
	val experienceV1: ExperienceV1? = null,

	@field:SerializedName("industry_v1")
	val industryV1: IndustryV1? = null,

	@field:SerializedName("highest_qualification_v1")
	val highestQualificationV1: HighestQualificationV1? = null,

	@field:SerializedName("monthly_income_v1")
	val monthlyIncomeV1: Any? = null,

	@field:SerializedName("field_of_study_v1")
	val fieldOfStudyV1: FieldOfStudyV1? = null
)

data class PreferenceQuestion(

	@field:SerializedName("second_choice")
	val secondChoice: String? = null,

	@field:SerializedName("first_choice")
	val firstChoice: String? = null
)

data class SunSignV1(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class SmokingV1(

	@field:SerializedName("name_alias")
	val nameAlias: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class DrinkingV1(

	@field:SerializedName("name_alias")
	val nameAlias: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class MaritalStatusV1(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("preference_only")
	val preferenceOnly: Boolean? = null
)

data class Location(

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("full")
	val full: String? = null
)

data class Likes(

	@field:SerializedName("likes_received_count")
	val likesReceivedCount: Int? = null,

	@field:SerializedName("profiles")
	val profiles: List<ProfilesItem?>? = null,

	@field:SerializedName("can_see_profile")
	val canSeeProfile: Boolean? = null
)

data class FieldOfStudyV1(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Invites(

	@field:SerializedName("pending_invitations_count")
	val pendingInvitationsCount: Int? = null,

	@field:SerializedName("profiles")
	val profiles: List<ProfilesItem?>? = null,

	@field:SerializedName("totalPages")
	val totalPages: Int? = null
)

data class GeneralInformation(

	@field:SerializedName("ref_id")
	val refId: String? = null,

	@field:SerializedName("politics")
	val politics: Any? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("date_of_birth")
	val dateOfBirth: String? = null,

	@field:SerializedName("smoking_v1")
	val smokingV1: SmokingV1? = null,

	@field:SerializedName("kid")
	val kid: Any? = null,

	@field:SerializedName("settle")
	val settle: Any? = null,

	@field:SerializedName("faith")
	val faith: Faith? = null,

	@field:SerializedName("cast")
	val cast: Any? = null,

	@field:SerializedName("drinking_v1")
	val drinkingV1: DrinkingV1? = null,

	@field:SerializedName("marital_status_v1")
	val maritalStatusV1: MaritalStatusV1? = null,

	@field:SerializedName("sun_sign_v1")
	val sunSignV1: SunSignV1? = null,

	@field:SerializedName("date_of_birth_v1")
	val dateOfBirthV1: String? = null,

	@field:SerializedName("mbti")
	val mbti: Any? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("diet")
	val diet: Any? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("pet")
	val pet: Any? = null,

	@field:SerializedName("age")
	val age: Int? = null,

	@field:SerializedName("mother_tongue")
	val motherTongue: MotherTongue? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class HighestQualificationV1(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("preference_only")
	val preferenceOnly: Boolean? = null
)

data class IndustryV1(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("preference_only")
	val preferenceOnly: Boolean? = null
)

data class PreferencesItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("preference_question")
	val preferenceQuestion: PreferenceQuestion? = null,

	@field:SerializedName("answer_id")
	val answerId: Int? = null,

	@field:SerializedName("value")
	val value: Int? = null,

	@field:SerializedName("answer")
	val answer: String? = null,

	@field:SerializedName("second_choice")
	val secondChoice: String? = null,

	@field:SerializedName("first_choice")
	val firstChoice: String? = null
)

data class ExperienceV1(

	@field:SerializedName("name_alias")
	val nameAlias: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
