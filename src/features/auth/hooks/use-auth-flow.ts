import { useLoginWithEmail } from "@privy-io/react-auth";
import { useState } from "react";
import type { Step } from "../types/step.type";

export const useAuthFlow = () => {
  const [step, setStep] = useState<Step>("email");
  const [email, setEmail] = useState<string>("");
  const [error, setError] = useState<string>("");

  const { sendCode, loginWithCode, state } = useLoginWithEmail({
    onError(error) {
      setError(error);
      console.log("Auth error:", error);
    },
  });

  const submitEmail = async (email: string) => {
    if (!email) return;
    
    setError("");
    await sendCode({ email: email });
    setEmail(email);
    setStep("otp");
  };

  const submitOtp = async (otp: string) => {
    if (otp.length !== 6) return;
    setError("");
    await loginWithCode({ code: otp });
  };

  const resend = async (email: string) => {
    console.log("Resend to:", email);
    if (!email) return;
    setError("");
    await sendCode({ email: email });
    console.log("Look state:", state.status);
  };

  const reset = () => {
    setStep("email");
    setEmail("");
    setError("");
  };

  return {
    step,
    email,
    state,
    error,
    submitEmail,
    submitOtp,
    resend,
    reset,
    isSendingCode: state.status === "sending-code",
    isAwaitingOtp: state.status === "awaiting-code-input",
  };
};
