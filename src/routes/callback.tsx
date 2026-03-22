import { magic } from "@/lib/magic";
import { createFileRoute, useNavigate } from "@tanstack/react-router";
import { useEffect, useRef } from "react";
import Loading from "@/components/loading";

export const Route = createFileRoute("/callback")({
  component: CallbackComponent,
});

function CallbackComponent() {
  const navigate = useNavigate();
  const processed = useRef(false);

  useEffect(() => {
    const handleCallback = async () => {
      if (processed.current) return;
      processed.current = true;

      try {
        await magic.oauth2.getRedirectResult();
        navigate({ to: "/dashboard" });
      } catch (error) {
        console.error("Callback error:", error);
        navigate({ to: "/login" });
      }
    };

    handleCallback();
  }, [navigate]);

  return <Loading children={"Xác thực tài khoản"} />;
}
