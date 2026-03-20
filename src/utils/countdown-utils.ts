export const countdownUtils = (seconds: number) => {
  // Return like munites:seconds / 04:25
  return `${Math.floor(seconds / 60)}:${seconds % 60}`
    .toString()
    .padStart(2, "0");
};
