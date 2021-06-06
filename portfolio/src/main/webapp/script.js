// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
// function all elements that need js
function onLoad() {
  getLastSong();
}

function timeSince(date) {
  // difference of time between initial date and now in seconds, divide by 1000 because js uses ms for time.
  let timeElapsed = Math.floor((new Date() - date) / 1000);
  const unitsInSecs = {
    'year': 31536000,
    'month': 2419200,
    'week': 604800,
    'day': 86400,
    'hour': 3600,
    'minute': 60,
    'second': 1,
  };

  for (const key in unitsInSecs) {
    if (timeElapsed % unitsInSecs[key] !== timeElapsed) {
      return `${Math.floor(timeElapsed / unitsInSecs[key])} ${key}${Math.floor(timeElapsed / unitsInSecs[key]) === 1 ? '' : 's'}`
    }
  }
}


function getLastSong(){
  const url = 'http://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=gmarsh0218&api_key=a228b6b2b58f233537d93206e9b768c5&format=json&limit=1';
  fetchAsync(url).then(data => {

    const trackData = data.recenttracks.track[0];
    const artistName = trackData.artist["#text"];
    const songName = trackData.name;
    const albumName = trackData.album["#text"];

    let listeningInfo;

    if(trackData["@attr"] && trackData["@attr"].nowplaying === "true"){
      listeningInfo = `I am currently listening to ${songName} by ${artistName}.` ;
    }
    else{
      let timeSinceSongPlayed = timeSince(trackData.date["uts"]);
      listeningInfo = `I was listening to ${songName} by ${artistName},  ${timeSinceSongPlayed} ago.`;
    }
    // set listening info
    document.getElementById("song-info").innerText = listeningInfo;
    //set album picture and alt text for accessibility purposes.
    document.getElementById("album-art").src = trackData.image[2]["#text"];
    document.getElementById("album-art").alt = albumName;
  });

  //fetchAsync() based on https://gist.github.com/msmfsd/fca50ab095b795eb39739e8c4357a808
  async function fetchAsync (url) {
    let response = await fetch(url);
    return await response.json();
  }

}
