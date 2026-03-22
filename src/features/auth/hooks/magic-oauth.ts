import { magic } from "@/lib/magic";
import { useState } from "react";

export const useMagicOAuth = () => {
  const [isLoading, setLoading] = useState<boolean>(false);

  const loginWithGoogle = async () => {
    setLoading(true);

    try {
      await magic.oauth2.loginWithRedirect({
        provider: "google",
        redirectURI: `${window.location.origin}/callback`,
      });
    } catch (error) {
      console.error("OAuth error:", error);
    } finally {
      setLoading(false);
    }
  };

  return { isLoading, loginWithGoogle };
};
