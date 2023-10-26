package net.azarquiel.nba.model

import com.google.gson.annotations.SerializedName

data class Team(
    var teams: List<Team>,
    var name:String,
    var conference : String,
    var record : String,
    var teamLogoUrl : String
)

