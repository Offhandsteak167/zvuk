const initUI = () => {
    const nameMessage = document.getElementById('name-message');
    const joinButton = document.getElementById('join-btn');
    const conferenceAliasInput = document.getElementById('alias-input');
    const leaveButton = document.getElementById('leave-btn');
    const lblDolbyVoice = document.getElementById('label-dolby-voice');

    const startAudioBtn = document.getElementById('start-audio-btn');
    const stopAudioBtn = document.getElementById('stop-audio-btn');


    // Update the login message with the name of the user
    nameMessage.innerHTML = `You are logged in as ${randomName}`;
    joinButton.disabled = false;

    joinButton.onclick = () => {
        // Default conference parameters
        // See: https://dolby.io/developers/interactivity-apis/client-sdk/reference-javascript/model/conferenceparameters
        let conferenceParams = {
            liveRecording: false,
            rtcpMode: "average", // worst, average, max
            ttl: 0,
            videoCodec: "H264", // H264, VP8
            dolbyVoice: true
        };

        // See: https://dolby.io/developers/interactivity-apis/client-sdk/reference-javascript/model/conferenceoptions
        let conferenceOptions = {
            alias: conferenceAliasInput.value,
            params: conferenceParams
        };

        // 1. Create a conference room with an alias
        VoxeetSDK.conference.create(conferenceOptions)
            .then((conference) => {
                // See: https://dolby.io/developers/interactivity-apis/client-sdk/reference-javascript/model/joinoptions
                const joinOptions = {
                    constraints: {
                        audio: true,
                        video: false
                    },
                    simulcast: false
                };

                // 2. Join the conference
                VoxeetSDK.conference.join(conference, joinOptions)
                    .then((conf) => {
                        lblDolbyVoice.innerHTML = `Dolby Voice is ${conf.params.dolbyVoice ? 'On' : 'Off'}.`;

                        conferenceAliasInput.disabled = true;
                        joinButton.disabled = true;
                        leaveButton.disabled = false;
                        startVideoBtn.disabled = false;
                        startAudioBtn.disabled = true;
                        stopAudioBtn.disabled = false;
                        startScreenShareBtn.disabled = false;
                        startRecordingBtn.disabled = false;
                    })
                    .catch((e) => console.log(e));
            })
            .catch((e) => console.log(e));
    };

    leaveButton.onclick = () => {
        // Leave the conference
        VoxeetSDK.conference.leave()
            .then(() => {
                lblDolbyVoice.innerHTML = '';

                conferenceAliasInput.disabled = false;
                joinButton.disabled = false;
                leaveButton.disabled = true;
                startVideoBtn.disabled = true;
                stopVideoBtn.disabled = true;
                startAudioBtn.disabled = true;
                stopAudioBtn.disabled = true;
                startScreenShareBtn.disabled = true;
                stopScreenShareBtn.disabled = true;
                startRecordingBtn.disabled = true;
                stopRecordingBtn.disabled = true;
            })
            .catch((e) => console.log(e));
    };
    startAudioBtn.onclick = () => {
        // Start sharing the Audio with the other participants
        VoxeetSDK.conference.startAudio(VoxeetSDK.session.participant)
            .then(() => {
                startAudioBtn.disabled = true;
                stopAudioBtn.disabled = false;
            })
            .catch((e) => console.log(e));
    };

    stopAudioBtn.onclick = () => {
        // Stop sharing the Audio with the other participants
        VoxeetSDK.conference.stopAudio(VoxeetSDK.session.participant)
            .then(() => {
                stopAudioBtn.disabled = true;
                startAudioBtn.disabled = false;
            })
            .catch((e) => console.log(e));
    };
};
// Add a new participant to the list
const addParticipantNode = (participant) => {
    // If the participant is the current session user, don't add himself to the list
    if (participant.id === VoxeetSDK.session.participant.id) return;

    let participantNode = document.createElement('li');
    participantNode.setAttribute('id', 'participant-' + participant.id);
    participantNode.innerText = `${participant.info.name}`;

    const participantsList = document.getElementById('participants-list');
    participantsList.appendChild(participantNode);
};

// Remove a participant from the list
const removeParticipantNode = (participant) => {
    let participantNode = document.getElementById('participant-' + participant.id);

    if (participantNode) {
        participantNode.parentNode.removeChild(participantNode);
    }
};

