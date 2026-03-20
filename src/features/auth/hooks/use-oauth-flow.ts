import { useLoginWithOAuth } from "@privy-io/react-auth";
import type { Provider } from "../types/provider.type";

export const useOAuthFlow = () => {
  const { initOAuth, loading, state } = useLoginWithOAuth({
    onError(error) {
      console.log("OAuth error:", error);
    },
  });

  const handleLogin = async (provider: Provider) => {
    if (loading) return;
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
