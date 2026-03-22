import { Magic } from "magic-sdk";
import { OAuthExtension } from "@magic-ext/oauth2";
import { ethers } from "ethers";

export const magic = new Magic(import.meta.env.VITE_MAGIC_API_KEY, {
  network: {
    rpcUrl: import.meta.env.VITE_ALCHEMY_RPC_URL,
    chainId: 11155111,
  },
  locale: "vi",
  deferPreload: true,
  extensions: [new OAuthExtension()],
});

export const provider = new ethers.BrowserProvider(magic.rpcProvider);
