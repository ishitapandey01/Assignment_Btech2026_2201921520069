let allselect = document.querySelectorAll("select");
let time = document.querySelector("h1");
let setbut = document.querySelector("button");
let contbox = document.querySelector(".content-box");
let alarmtime; // Store alarm time
let isAlarmSet = false; // Flag to check if alarm is set

console.log(allselect); // log for debugging

// Populating Hours (1-12)
for (let i = 12; i > 0; i--) {
    let hour = i < 10 ? "0" + i : i;
    let option = `<option value="${hour}">${hour}</option>`;
    allselect[0].innerHTML += option;
}

// Populating Minutes (00-59)
for (let i = 59; i >= 0; i--) {
    let minute = i < 10 ? "0" + i : i;
    let option = `<option value="${minute}">${minute}</option>`;
    allselect[1].innerHTML += option;
}

// Populating AM/PM
for (let i = 2; i > 0; i--) {
    let ampm = i == 1 ? "AM" : "PM";
    let option = `<option value="${ampm}">${ampm}</option>`;
    allselect[2].innerHTML += option;
}

// Getting hour, minute, second in real-time
setInterval(() => {
    let date = new Date();
    let h = date.getHours();
    let m = date.getMinutes();
    let s = date.getSeconds();
    let ampm = "AM";
    let ringtone = new Audio("ringtone.mp3");

    if (h >= 12) {
        ampm = "PM";
        if (h > 12) h -= 12;
    }
    if (h === 0) h = 12;

    h = h < 10 ? "0" + h : h;
    m = m < 10 ? "0" + m : m;
    s = s < 10 ? "0" + s : s;

    // Check if alarm time matches current time
    if (isAlarmSet && alarmtime === `${h}:${m} ${ampm}`) {
        ringtone.play();
        ringtone.loop = true;
    }

    time.innerText = `${h}:${m}:${s} ${ampm}`;
}, 1000); // Update every second

// Alarm Setting
const setAlarm = () => {
    let selectedTime = `${allselect[0].value}:${allselect[1].value} ${allselect[2].value}`;

    // Validate the selected time
    if (allselect[0].value === "Hour" || allselect[1].value === "Minute" || allselect[2].value === "AM/PM") {
        return swal("Warning", "Please select valid time", "warning");
    } else {
        alert(`Alarm set for: ${selectedTime}`);
    }

    contbox.classList.add("disabled"); // Disable content box when alarm is set
    setbut.innerText = "Clear Alarm"; // Change button text to clear alarm
    alarmtime = selectedTime; // Set the alarm time
    isAlarmSet = true; // Set the flag to true indicating alarm is set
};

// Clear Alarm Functionality
const clearAlarm = () => {
    alarmtime = null; // Reset alarm time
    contbox.classList.remove("disabled"); // Enable content box again
    setbut.innerText = "Set Alarm"; // Change button text back to "Set Alarm"
    isAlarmSet = false; // Reset the flag to false indicating no alarm is set
};

// Button click event to set or clear alarm
setbut.onclick = () => {
    if (!isAlarmSet) {
        setAlarm(); // Set the alarm if not already set
    } else {
        clearAlarm(); // Clear the alarm if it is set
    }

};
let secondsContainer = document.querySelector(".flip-container");
let secondsTop = document.querySelector(".flip-top");
let secondsBottom = document.querySelector(".flip-bottom");

function updateClock() {
    let now = new Date();
    let s = now.getSeconds();
    let formattedSeconds = s < 10 ? "0" + s : s;

    if (secondsTop.innerText !== formattedSeconds) {
        secondsTop.innerText = formattedSeconds;
        secondsBottom.innerText = formattedSeconds;
        
        // Add animation class
        secondsContainer.classList.add("flip-active");

        setTimeout(() => {
            secondsContainer.classList.remove("flip-active");
        }, 500);
    }
}

setInterval(updateClock, 1000);

