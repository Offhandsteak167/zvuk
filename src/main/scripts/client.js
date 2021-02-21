const avengersNames = ['Thor', 'Cap', 'Tony Stark', 'Black Panther', 'Black Widow', 'Hulk', 'Spider-Man'];
let randomName = avengersNames[Math.floor(Math.random() * avengersNames.length)];

const main = async () => {
    /* Event handlers */

    // When a stream is added to the conference
    VoxeetSDK.conference.on('streamAdded', (participant, stream) => {
        addParticipantNode(participant);
    });



    // When a stream is removed from the conference
    VoxeetSDK.conference.on('streamRemoved', (participant, stream) => {
        removeParticipantNode(participant);
    });

    try {
        // Initialize the Voxeet SDK
        // WARNING: It is best practice to use the VoxeetSDK.initializeToken function to initialize the SDK.
        // Please read the documentation at:
        // https://dolby.io/developers/interactivity-apis/client-sdk/initializing
        VoxeetSDK.initialize('Awv0-V3iuVQ3erlJb3O0cA==', '1Vx0eyttbDFh6vWLFb9jJnULsRM1fKcSmuDnsmC0KDE=');

        // Open a session for the user
        await VoxeetSDK.session.open({ name: randomName });

        // Initialize the UI
        initUI();
    } catch (e) {
        alert('Something went wrong : ' + e);
    }
}

main()