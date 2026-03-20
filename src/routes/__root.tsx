import { createRootRoute, Outlet } from "@tanstack/react-router";
import { PrivyProvider } from "@privy-io/react-auth";
const PRIVY_APP_ID = import.meta.env.VITE_PRIVY_APP_ID;
import { NotFoundPage } from "./not-found";

export const Route = createRootRoute({
  component: () => (
    <PrivyProvider
      appId={PRIVY_APP_ID}
      config={{
        appearance: {
          logo: "/logo.svg",
          theme: "light",
          accentColor: "#f5f5f5",
        },
        loginMethods: ["google", "email", "apple"],
        fundingMethodConfig: {
          moonpay: {
            useSandbox: true,
          },
        },
        embeddedWallets: {
          showWalletUIs: true,
          ethereum: {
            createOnLogin: "off",
          },
          solana: {
            createOnLogin: "off",
          },
        },
        mfa: {
          noPromptOnMfaRequired: false,
        },
      }}
    >
      <Outlet />
    </PrivyProvider>
  ),
  notFoundComponent: () => <NotFoundPage />,
});
