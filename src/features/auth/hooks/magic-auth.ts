import { magic } from "@/lib/magic";
import { useNavigate } from "@tanstack/react-router";
import { useState } from "react";

export const useMagicAuth = () => {
  const [isLoading, setLoading] = useState<boolean>(false);
  const nagivate = useNavigate();

  const login = async (email: string) => {
    setLoading(true);

    try {
      const handle = magic.auth.loginWithMagicLink({
        email,
        showUI: true,
      });

      handle.on("done", () => {
        nagivate({ to: "/dashboard" });
      });
    } catch (error) {
      console.error("User cancelled or error:", error);
    } finally {
      setLoading(false);
    }
  };

  return { isLoading, login };
};
