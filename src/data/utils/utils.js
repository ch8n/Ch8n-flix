export default {
    ellipse : (inputStr, length) => {
        return inputStr?.length > length ? inputStr.substr(0, length - 1) + "..." : inputStr
    },
}