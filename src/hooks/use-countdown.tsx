import { useEffect, useState } from "react";

export const useCountdown = (countdownSeconds: number) => {
  const [countdown, setCountdown] = useState<number>(countdownSeconds);
  const [isCounting, setCounting] = useState<boolean>(true);

  useEffect(() => {
    if (!isCounting) return;

    const interval = setInterval(() => {
      setCountdown((prev) => {
        if (prev <= 1) {
          clearInterval(interval);
          setCounting(false);
          return 0;
        }
        return prev - 1;
      });
    }, 1000);

    return () => clearInterval(interval);
  }, [isCounting]);

  const restart = () => {
    setCountdown(countdownSeconds);
    setCounting(true);
  };

  return { countdown, isCounting, restart };
};
