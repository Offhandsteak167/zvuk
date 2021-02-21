const initUI = () => {
    const nameMessage = document.getElementById('name-message');
    const joinButton = document.getElementById('join-btn');
    const leaveButton = document.getElementById('leave-btn');
    const lblDolbyVoice = document.getElementById('label-dolby-voice');


    // Update the login message with the name of the user
    nameMessage.innerHTML = `You are logged in`;
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
            alias: 'alias',
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

                        joinButton.disabled = true;
                        leaveButton.disabled = false;
                        startVideoBtn.disabled = false;
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

                joinButton.disabled = false;
                leaveButton.disabled = true;
                startVideoBtn.disabled = true;
                stopVideoBtn.disabled = true;
                startScreenShareBtn.disabled = true;
                stopScreenShareBtn.disabled = true;
                startRecordingBtn.disabled = true;
                stopRecordingBtn.disabled = true;
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


};

// Remove a participant from the list
const removeParticipantNode = (participant) => {
    let participantNode = document.getElementById('participant-' + participant.id);

    if (participantNode) {
        participantNode.parentNode.removeChild(participantNode);
    }
};

