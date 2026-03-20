import { useLoginWithOAuth } from "@privy-io/react-auth";
import type { Provider } from "../types/provider.type";
import { useNavigate } from "@tanstack/react-router";

export const useOAuthFlow = () => {
  const navigate = useNavigate();

  const { initOAuth, loading, state } = useLoginWithOAuth({
    onComplete: ({ user }) => {},
    onError(error) {
      console.log("OAuth error:", error);
    },
  });

  const handleLogin = async (provider: Provider) => {
    if (loading || state.status === "loading") return;
    try {
      await initOAuth({ provider: provider });
    } catch (error) {
      console.error("OAuth error:", error);
    }
  };

  return {
    loading,
    state,

    handleLogin,

    isLoading: state.status === "loading",
    isError: state.status === "error",
    isDone: state.status === "done",
  };
};
